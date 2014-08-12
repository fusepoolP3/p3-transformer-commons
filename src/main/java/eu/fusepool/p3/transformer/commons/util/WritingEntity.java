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
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Use this if you want to create an Entity and by writing data to an OutputStream;
 */
public abstract class WritingEntity implements Entity {


    @Override
    public InputStream getData() throws IOException {
        final PipedInputStream pipedInputStream = new PipedInputStream();
        final PipedOutputStream pipedOutputStream = new PipedOutputStream(pipedInputStream);
        (new Thread() {

            @Override
            public void run() {
                try {
                    WritingEntity.this.writeData(pipedOutputStream);
                    pipedOutputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(WritingEntity.class.getName()).log(Level.SEVERE, null, ex);
                    throw new RuntimeException(ex);
                }
            }
            
        }).start();
        return pipedInputStream;
    }
    
    @Override
    public URI getContentLocation() {
        return null;
    }

    
}
