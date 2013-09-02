/**
 * Copyright (c) 2012-2013 Reficio (TM) - Reestablish your software!. All Rights Reserved.
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.reficio.ws.camel;

import org.apache.camel.builder.RouteBuilder;

/**
 * @author piotr.jagielski
 */
public class SoapWsExampleRouteBuilder extends RouteBuilder {

    public void configure() throws Exception {
        from("soap-ws:server?port=9090&context=/service&" +
             "wsdl=wsdl/currency-convertor.wsdl&" +
             "localPart=CurrencyConvertorSoap")
            .recipientList(simple("direct:${header.operation}"))
            .transform(constant("<a>bc</a>"));

        from("direct:send")
            .to("soap-ws:http://localhost:51515/service?" +
                "wsdl=wsdl/currency-convertor.wsdl&" +
                "localPart=CurrencyConvertorSoap");
    }

}