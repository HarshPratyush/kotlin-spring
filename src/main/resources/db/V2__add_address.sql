--Copyright 2022 Harsh Pratyush
--
--Licensed under the Apache License, Version 2.0 (the "License");
--you may not use this file except in compliance with the License.
--You may obtain a copy of the License at
--
--    http://www.apache.org/licenses/LICENSE-2.0
--
--Unless required by applicable law or agreed to in writing, software
--distributed under the License is distributed on an "AS IS" BASIS,
--WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
--See the License for the specific language governing permissions and
--limitations under the License.


CREATE TABLE IF NOT EXISTS address(
address_id BIGSERIAL,
street1 character varying(20) NOT NULL,
street2 character varying(20) NOT NULL,
street3 character varying(20),
city character varying(20) NOT NULL,
state character varying(20) NOT NULL,
country character varying(20) NOT NULL,
pincode character varying(20) NOT NULL,
CONSTRAINT address_pkey PRIMARY KEY (address_id)
);

ALTER TABLE employee add column address_id bigint ;