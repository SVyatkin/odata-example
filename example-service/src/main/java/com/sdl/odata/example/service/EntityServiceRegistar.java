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
package com.sdl.odata.example.service;

import com.google.common.collect.Lists;
import com.sdl.odata.api.ODataException;
import com.sdl.odata.api.edm.registry.ODataEdmRegistry;
import com.sdl.odata.example.Datapoint;
import com.sdl.odata.example.datasource.InMemoryDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author rdevries
 */
@Component
public class EntityServiceRegistar {
    private static final Logger LOG = LoggerFactory.getLogger(EntityServiceRegistar.class);

    @Autowired
    private ODataEdmRegistry oDataEdmRegistry;

    @Autowired
    private InMemoryDataSource inMemoryDataSource;

    @PostConstruct
    public void registerEntities() throws ODataException {
        LOG.debug("Registering example entities");

        oDataEdmRegistry.registerClasses(Lists.newArrayList(
                Datapoint.class,
                GetAverageAge.class
        ));

        List<Datapoint> persons = Lists.newArrayList(
                new Datapoint("1", "TagTest", "Attribute", 1488490548525L, 1, 0),
                new Datapoint("2", "TagTest", "Attribute", 1488490549525L, 2, 1),
                new Datapoint("3", "TagTest", "Attribute", 1488490550525L, 2, 2),
                new Datapoint("4", "TagTest", "Attribute", 1488490559525L, 3, 3));

        for (Datapoint person : persons) {
            inMemoryDataSource.create(null, person, null);
        }
    }
}
