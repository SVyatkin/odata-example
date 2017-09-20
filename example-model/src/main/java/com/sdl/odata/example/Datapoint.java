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

	@EdmProperty(name = "timeStamp", nullable = false)
    private long timeStamp;

    @EdmProperty(name = "datapoint", nullable = false)
    private double datapoint;
    
    @EdmProperty(name = "quality", nullable = true)
    private int quality;
    
    @EdmProperty(name = "attrName01", nullable = true)
	private String attrName01;

    @EdmProperty(name = "attrValue01", nullable = true)
	private String attrValue01;

    @EdmProperty(name = "attrName02", nullable = true)
	private String attrName02;

    @EdmProperty(name = "attrValue02", nullable = true)
	private String attrValue02;

    @EdmProperty(name = "attrName03", nullable = true)
	private String attrName03;

    @EdmProperty(name = "attrValue03", nullable = true)
	private String attrValue03;

    @EdmProperty(name = "attrName04", nullable = true)
	private String attrName04;

    @EdmProperty(name = "attrValue04", nullable = true)
	private String attrValue04;

	public Datapoint(String id, String tagName, long timeStamp, double datapoint, int quality, String attrName01,
			String attrValue01, String attrName02, String attrValue02, String attrName03, String attrValue03,
			String attrName04, String attrValue04) {
		this.id = id;
		this.tagName = tagName;
		this.timeStamp = timeStamp;
		this.datapoint = datapoint;
		this.quality = quality;
		this.attrName01 = attrName01;
		this.attrValue01 = attrValue01;
		this.attrName02 = attrName02;
		this.attrValue02 = attrValue02;
		this.attrName03 = attrName03;
		this.attrValue03 = attrValue03;
		this.attrName04 = attrName04;
		this.attrValue04 = attrValue04;
	}
	
    public Datapoint() {
    }

    public String getId() {
        return id;
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

    public double getDatapoint() {
        return datapoint;
    }

    public void setDatapoint(double age) {
        this.datapoint = age;
    }

	public String getAttrName01() {
		return attrName01;
	}

	public void setAttrName01(String attrName01) {
		this.attrName01 = attrName01;
	}

	public String getAttrValue01() {
		return attrValue01;
	}

	public void setAttrValue01(String attrValue01) {
		this.attrValue01 = attrValue01;
	}

	public String getAttrName02() {
		return attrName02;
	}

	public void setAttrName02(String attrName02) {
		this.attrName02 = attrName02;
	}

	public String getAttrValue02() {
		return attrValue02;
	}

	public void setAttrValue02(String attrValue02) {
		this.attrValue02 = attrValue02;
	}

	public String getAttrName03() {
		return attrName03;
	}

	public void setAttrName03(String attrName03) {
		this.attrName03 = attrName03;
	}

	public String getAttrValue03() {
		return attrValue03;
	}

	public void setAttrValue03(String attrValue03) {
		this.attrValue03 = attrValue03;
	}

	public String getAttrName04() {
		return attrName04;
	}

	public void setAttrName04(String attrName04) {
		this.attrName04 = attrName04;
	}

	public String getAttrValue04() {
		return attrValue04;
	}

	public void setAttrValue04(String attrValue04) {
		this.attrValue04 = attrValue04;
	}
}
