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

package eu.fusepool.p3.transformer.commons;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.activation.MimeType;


/**
 * Represents a data entity.
 * 
 * @author reto
 */
public interface Entity {

    /**
     * @return The media type of this entity
     */
    MimeType getType();

    /**
     * 
     * @return an InputStream from which the content of this entity can be read
     * @throws IOException 
     */
    InputStream getData() throws IOException;
    
    /**
     * This method writes the content of this Entity to an OutputStream
     * 
     * @param out the OutputStream to which the content shall be written
     * @throws IOException 
     */
    void writeData(OutputStream out) throws IOException;
    
}
