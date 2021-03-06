/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.sling.scripting.esx.plugins;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.adapter.AdapterFactory;
import org.apache.sling.api.resource.Resource;

@Component
@Service
public class SimpleResourceAdapterFactory implements AdapterFactory {

    @Property(name = "adapters")
    public static final String[] ADAPTER_CLASSES = {
        SimpleResource.class.getName()
    };
    @Property(name = "adaptables")
    public static final String[] ADAPTABLE_CLASSES = {
        Resource.class.getName()
    };

    @Override
    public <AdapterType> AdapterType getAdapter(Object adaptableObject, Class<AdapterType> type) {
        if (type.equals(SimpleResource.class)
                && adaptableObject instanceof Resource) {

            SimpleResource simpeResource = new SimpleResource((Resource) adaptableObject);

            return (AdapterType) simpeResource;
        } else {
            return null;
        }
    }

}
