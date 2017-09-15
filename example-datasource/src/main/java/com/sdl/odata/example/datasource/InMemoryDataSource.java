/**
 * Copyright (c) 2015 SDL Group
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sdl.odata.example.datasource;

import com.sdl.odata.api.ODataException;
import com.sdl.odata.api.ODataSystemException;
import com.sdl.odata.api.edm.model.EntityDataModel;
import com.sdl.odata.api.parser.ODataUri;
import com.sdl.odata.api.parser.ODataUriUtil;
import com.sdl.odata.api.processor.datasource.DataSource;
import com.sdl.odata.api.processor.datasource.ODataDataSourceException;
import com.sdl.odata.api.processor.datasource.TransactionalDataSource;
import com.sdl.odata.api.processor.link.ODataLink;
import com.sdl.odata.example.Datapoint;
import org.springframework.stereotype.Component;
import scala.Option;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author rdevries
 */
@Component
public class InMemoryDataSource implements DataSource {

    private ConcurrentMap<String, Datapoint> personConcurrentMap = new ConcurrentHashMap<>();


    @Override
    public Object create(ODataUri oDataUri, Object o, EntityDataModel entityDataModel) throws ODataException {
        Datapoint dt = (Datapoint) o;
        if(personConcurrentMap.putIfAbsent(dt.getId(), dt) != null) {
            throw new ODataDataSourceException("Could not create entity, already exists");
        }

        return dt;
    }

    @Override
    public Object update(ODataUri oDataUri, Object o, EntityDataModel entityDataModel) throws ODataException {
        Datapoint dt = (Datapoint) o;
        if(personConcurrentMap.containsKey(dt.getId())) {
            personConcurrentMap.put(dt.getId(), dt);

            return dt;
        } else {
            throw new ODataDataSourceException("Unable to update, entity does not exist");
        }
    }

    @Override
    public void delete(ODataUri oDataUri, EntityDataModel entityDataModel) throws ODataException {
        Option<Object> entity = ODataUriUtil.extractEntityWithKeys(oDataUri, entityDataModel);
        if(entity.isDefined()) {
            Datapoint person = (Datapoint) entity.get();
            personConcurrentMap.remove(person.getId());
        }
    }

    @Override
    public TransactionalDataSource startTransaction() {
        throw new ODataSystemException("No support for transactions");
    }

    public ConcurrentMap<String, Datapoint> getPersonConcurrentMap() {
        return personConcurrentMap;
    }

    @Override
    public void createLink(ODataUri oDataUri, ODataLink oDataLink, EntityDataModel entityDataModel) throws ODataException {

    }

    @Override
    public void deleteLink(ODataUri oDataUri, ODataLink oDataLink, EntityDataModel entityDataModel) throws ODataException {

    }
}
