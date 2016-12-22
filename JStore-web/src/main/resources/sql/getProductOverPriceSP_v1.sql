CREATE OR REPLACE FUNCTION PRODUCT_OVER_PRICE_V1 (
    _price bigint,
    _catalog_id bigint)
  RETURNS SETOF product AS
$BODY$
  SELECT * FROM product WHERE price > _price AND catalog_id = _catalog_id
$BODY$
LANGUAGE sql;
