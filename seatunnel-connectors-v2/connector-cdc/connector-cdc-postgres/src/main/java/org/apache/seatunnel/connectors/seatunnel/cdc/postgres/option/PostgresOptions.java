/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.seatunnel.connectors.seatunnel.cdc.postgres.option;

import org.apache.seatunnel.api.configuration.Option;
import org.apache.seatunnel.api.configuration.Options;

import java.util.List;

public interface PostgresOptions {

    Option<String> DECODING_PLUGIN_NAME =
            Options.key("decoding-plugin-name")
                    .stringType()
                    .defaultValue("pgoutput")
                    .withDescription(
                            "The name of the Postgres logical decoding plug-in installed on the server.\n"
                                    + "Supported values are decoderbufs, wal2json, wal2json_rds, wal2json_streaming,\n"
                                    + "wal2json_rds_streaming and pgoutput.");

    Option<String> SLOT_NAME =
            Options.key("slot-name")
                    .stringType()
                    .defaultValue("seatunnel_slot")
                    .withDescription(
                            "The name of the Postgres logical decoding slot created for streaming changes from a plugin."
                                    + "Defaults to 'seatunnel_slot");
    Option<String> PUBLICATION_NAME =
            Options.key("publication-name")
                    .stringType()
                    .defaultValue("seatunnel_pub")
                    .withDescription(
                            "The name of the Postgres 10+ publication used for streaming changes from a plugin.");
    Option<String> DATABASE_NAME =
            Options.key("database-name")
                    .stringType()
                    .defaultValue("postgres")
                    .withDescription("TDatabase name of the database to monitor");

    Option<List<String>> SCHEMA_INCLUDE_LIST =
            Options.key("schema-list")
                    .listType()
                    .noDefaultValue()
                    .withDescription("Schema list of the schema to monitor.");
}