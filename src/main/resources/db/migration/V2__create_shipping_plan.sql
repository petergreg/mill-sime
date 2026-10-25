CREATE TABLE shipping_plan
(
    id            BIGINT PRIMARY KEY,
    reference     VARCHAR(255)             NOT NULL,
    farmer_id     BIGINT                   NOT NULL,
    cereal        VARCHAR(255)             NOT NULL,
    shipping_date TIMESTAMP WITH TIME ZONE NOT NULL
);
ALTER TABLE shipping_plan
    ADD CONSTRAINT shipping_plan_reference_unique UNIQUE (reference);
ALTER TABLE shipping_plan
    ADD CONSTRAINT shipping_plan_farmer_fk FOREIGN KEY (farmer_id) REFERENCES farmer (id);
ALTER TABLE shipping_plan
    ADD CONSTRAINT shipping_plan_farmer_cereal_date_unique UNIQUE (farmer_id, cereal, shipping_date);
CREATE SEQUENCE seq_shipping_plan;
