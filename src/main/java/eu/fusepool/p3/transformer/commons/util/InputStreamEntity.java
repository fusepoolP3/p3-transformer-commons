/*
 * Copyright (C) 2014 Bern University of Applied Sciences.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package eu.fusepool.p3.transformer.commons.util;

import eu.fusepool.p3.transformer.commons.Entity;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.io.IOUtils;

/**
 * Use this is you have an InputStream and need an Entity.
 */
public abstract class InputStreamEntity implements Entity {

    @Override
    public void writeData(OutputStream out) throws IOException {
        IOUtils.copy(getData(), out);
    }
    
}
