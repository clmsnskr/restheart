/*
 * RESTHeart - the Web API for MongoDB
 * Copyright (C) SoftInstigate Srl
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.restheart.init;

import org.restheart.handlers.metadata.ResponseTransformerHandler;
import org.restheart.metadata.transformers.WriteResultTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Andrea Di Cesare <andrea@softinstigate.com>
 */
public class TestInitializer implements Initializer {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestInitializer.class);
    
    @Override
    public void init() {
        ResponseTransformerHandler.getGlobalTransformers().add(
                new WriteResultTransformer());
        LOGGER.info("Added WriteResultTransformer as global transformer");
        LOGGER.info("It adds to write requests a response body with new and old document data");        
    }
}
