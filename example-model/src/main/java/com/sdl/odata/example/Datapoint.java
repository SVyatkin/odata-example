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
package com.sdl.odata.example;

import com.sdl.odata.api.edm.annotations.EdmEntity;
import com.sdl.odata.api.edm.annotations.EdmEntitySet;
import com.sdl.odata.api.edm.annotations.EdmProperty;

/**
 * @author rdevries
 */
@EdmEntity(namespace = "SDL.OData.TS", key = "id", containerName = "SDLExample")
@EdmEntitySet
public class Datapoint {

    @EdmProperty(name = "id", nullable = false)
    private String id;

    @EdmProperty(name = "tagName", nullable = false)
    private String tagName;
    
    @EdmProperty(name = "attribute", nullable = false)
    private String attribute;

	@EdmProperty(name = "timeStamp", nullable = false)
    private long timeStamp;

    @EdmProperty(name = "datapoint", nullable = false)
    private int datapoint;
    
    @EdmProperty(name = "quality", nullable = true)
    private int quality;

    public Datapoint(String id, String tagName, String attribute, long timeStamp, int datapoint, int quality) {
        this.id = id;
        this.tagName = tagName;
        this.attribute = attribute;
        this.timeStamp = timeStamp;
        this.datapoint = datapoint;
        this.quality = quality;
    }

    public Datapoint() {
    }

    public String getId() {
        return id;
    }

    public String getAttribute() {
    	return attribute;
    }
    
    public void setAttribute(String attribute) {
    	this.attribute = attribute;
    }
    
    public int getQuality() {
    	return quality;
    }
    
    public void setQuality(int quality) {
    	this.quality = quality;
    }
    
    public void setId(String personId) {
        this.id = personId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long lastName) {
        this.timeStamp = lastName;
    }

    public int getDatapoint() {
        return datapoint;
    }

    public void setDatapoint(int age) {
        this.datapoint = age;
    }
}
