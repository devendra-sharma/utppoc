-- TODO: Rmeove the configuration tables from the list of delete tables
use mydb;

SET foreign_key_checks = 0;
DELETE FROM ticket_status_link;
DELETE FROM ticket_status;
DELETE FROM route_link;
DELETE FROM route;
DELETE FROM record_field;
DELETE FROM product_link;
DELETE FROM product;
DELETE FROM ticket_class;
DELETE FROM ticket_allocation_code;
DELETE FROM product_type;
DELETE FROM process_control;
DELETE FROM location_link;
DELETE FROM location;
DELETE FROM location_type;
DELETE FROM instance_control_log;
DELETE FROM group_function_type;
DELETE FROM fares_checking_exclusion;
DELETE FROM code_book;
DELETE FROM type;
DELETE FROM calendar;
DELETE FROM week;
DELETE FROM period;
DELETE FROM year;
DELETE FROM business;
DELETE FROM application_parameters;
SET foreign_key_checks = 1;

COMMIT;

USE mydb ;

INSERT INTO `type` (`typ_id`,`type`,`maintain_type`,`expired`,`effective_from`,`effective_to`) VALUES (1,'CURRENCY',NULL,NULL,NULL,NULL);
INSERT INTO `type` (`typ_id`,`type`,`maintain_type`,`expired`,`effective_from`,`effective_to`) VALUES (2,'TICKETTYPE',NULL,NULL,NULL,NULL);
INSERT INTO `type` (`typ_id`,`type`,`maintain_type`,`expired`,`effective_from`,`effective_to`) VALUES (3,'TICKETSTATUS',NULL,NULL,NULL,NULL);

INSERT INTO `code_book` VALUES (3,'ADULT_TIC',NULL,NULL,NULL,NULL,NULL,NULL,NULL,2);
INSERT INTO `code_book` VALUES (4,'CHILD_TIC',NULL,NULL,NULL,NULL,NULL,NULL,NULL,2);
INSERT INTO `code_book` VALUES (300,'STERLING',NULL,NULL,NULL,NULL,NULL,NULL,NULL,1);
INSERT INTO `code_book` VALUES (400,'EUROS',NULL,NULL,NULL,NULL,NULL,NULL,NULL,1);
INSERT INTO `code_book` VALUES (500,'STERLING',NULL,NULL,NULL,NULL,NULL,NULL,NULL,1);

INSERT INTO `fares_checking_exclusion` (`fares_checking_exclusion_id`,`value`,`ISSUING_LOCATION`,`SELLING_LOCATION`,`ORIGIN_LOCATION`,`DESTINATION_LOCATION`,`ROUTE`,`PRODUCT`,`TICKET_STATUS`,`FARE`,`WITH_EFFECT_FROM`,`WITH_EFFECT_UNTIL`,`NULL_FARE`) VALUES (1,'val','pune','pune','mumbai','kolkatta','RC1','PROD1','ACT','300','2014-06-06','2014-08-08',NULL);
INSERT INTO `business` (`bus_id`,`bus_id_tp`,`expired`,`effective_from`,`effective_to`,`bus_description`,`bus_name`,`bus_code`,`scans_substitute_bus_code`,`businesscol`,`atoc_substitute_bus_code`,`bus_id_tp_parent`,`tp_par_bus_description`,`tp_par_bus_name`,`tp_par_bus_code`,`bus_id_hoc`,`hoc_bus_description`,`hoc_bus_name`,`hoc_bus_code`,`bus_id_prc`,`prc_bus_description`,`prc_bus_name`,`prc_bus_code`,`bus_id_isd`,`isd_bus_description`,`isd_bus_name`,`isd_bus_code`,`bus_id_esd`,`esd_bus_description`,`esd_bus_name`,`esd_bus_code`,`bus_id_but`,`but_bus_description`,`but_bus_name`,`but_bus_code`,`ftf_site_identity`,`euro_conversion_date`) VALUES (1,123,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `location_type` (`lot_id`,`location_type_desc`,`expired`,`effective_from`,`effective_to`) VALUES (1,'City',NULL,'2015-06-06','2015-06-06');

INSERT INTO `location` (`loc_id`,`location`,`location_description`,`lot_id`,`address`,`postcode`,`telephone`,`loc_id_primary_zone`,`primary_zone_code`,`primary_zone_desc`,`loc_id_secondary_zone`,`secondary_zone_code`,`secondary_zone_desc`,`loc_id_tertiary_zone`,`tertiary_zone_code`,`tertiary_zone_desc`,`loc_id_tv_station`,`tv_station_code`,`tv_station_name`,`loc_id_local_authority`,`local_authority_code`,`local_authority_name`,`loc_id_station_group`,`station_group`,`station_group_desc`,`loc_id_london_station_grp`,`london_station_grp_code`,`london_station_grp_desc`,`os_grid_reference`,`postal_region`,`nalco_12char_description`,`nalco_16char_description`,`nalco_26char_description`,`nalco_tiploc`,`nalco_3char_code`,`effective_from`,`effective_to`,`expired`,`loc_id_master_account`,`master_account_code`,`master_account_name`,`cob_id_group_type`) VALUES (1,'mumbai','India',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1);
INSERT INTO `location` (`loc_id`,`location`,`location_description`,`lot_id`,`address`,`postcode`,`telephone`,`loc_id_primary_zone`,`primary_zone_code`,`primary_zone_desc`,`loc_id_secondary_zone`,`secondary_zone_code`,`secondary_zone_desc`,`loc_id_tertiary_zone`,`tertiary_zone_code`,`tertiary_zone_desc`,`loc_id_tv_station`,`tv_station_code`,`tv_station_name`,`loc_id_local_authority`,`local_authority_code`,`local_authority_name`,`loc_id_station_group`,`station_group`,`station_group_desc`,`loc_id_london_station_grp`,`london_station_grp_code`,`london_station_grp_desc`,`os_grid_reference`,`postal_region`,`nalco_12char_description`,`nalco_16char_description`,`nalco_26char_description`,`nalco_tiploc`,`nalco_3char_code`,`effective_from`,`effective_to`,`expired`,`loc_id_master_account`,`master_account_code`,`master_account_name`,`cob_id_group_type`) VALUES (2,'kolkatta','India',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1);
INSERT INTO `location` (`loc_id`,`location`,`location_description`,`lot_id`,`address`,`postcode`,`telephone`,`loc_id_primary_zone`,`primary_zone_code`,`primary_zone_desc`,`loc_id_secondary_zone`,`secondary_zone_code`,`secondary_zone_desc`,`loc_id_tertiary_zone`,`tertiary_zone_code`,`tertiary_zone_desc`,`loc_id_tv_station`,`tv_station_code`,`tv_station_name`,`loc_id_local_authority`,`local_authority_code`,`local_authority_name`,`loc_id_station_group`,`station_group`,`station_group_desc`,`loc_id_london_station_grp`,`london_station_grp_code`,`london_station_grp_desc`,`os_grid_reference`,`postal_region`,`nalco_12char_description`,`nalco_16char_description`,`nalco_26char_description`,`nalco_tiploc`,`nalco_3char_code`,`effective_from`,`effective_to`,`expired`,`loc_id_master_account`,`master_account_code`,`master_account_name`,`cob_id_group_type`) VALUES (3,'pune','India',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1);
INSERT INTO `location` (`loc_id`,`location`,`location_description`,`lot_id`,`address`,`postcode`,`telephone`,`loc_id_primary_zone`,`primary_zone_code`,`primary_zone_desc`,`loc_id_secondary_zone`,`secondary_zone_code`,`secondary_zone_desc`,`loc_id_tertiary_zone`,`tertiary_zone_code`,`tertiary_zone_desc`,`loc_id_tv_station`,`tv_station_code`,`tv_station_name`,`loc_id_local_authority`,`local_authority_code`,`local_authority_name`,`loc_id_station_group`,`station_group`,`station_group_desc`,`loc_id_london_station_grp`,`london_station_grp_code`,`london_station_grp_desc`,`os_grid_reference`,`postal_region`,`nalco_12char_description`,`nalco_16char_description`,`nalco_26char_description`,`nalco_tiploc`,`nalco_3char_code`,`effective_from`,`effective_to`,`expired`,`loc_id_master_account`,`master_account_code`,`master_account_name`,`cob_id_group_type`) VALUES (50483 ,'bnglr','India',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1);
INSERT INTO `location` (`loc_id`,`location`,`location_description`,`lot_id`,`address`,`postcode`,`telephone`,`loc_id_primary_zone`,`primary_zone_code`,`primary_zone_desc`,`loc_id_secondary_zone`,`secondary_zone_code`,`secondary_zone_desc`,`loc_id_tertiary_zone`,`tertiary_zone_code`,`tertiary_zone_desc`,`loc_id_tv_station`,`tv_station_code`,`tv_station_name`,`loc_id_local_authority`,`local_authority_code`,`local_authority_name`,`loc_id_station_group`,`station_group`,`station_group_desc`,`loc_id_london_station_grp`,`london_station_grp_code`,`london_station_grp_desc`,`os_grid_reference`,`postal_region`,`nalco_12char_description`,`nalco_16char_description`,`nalco_26char_description`,`nalco_tiploc`,`nalco_3char_code`,`effective_from`,`effective_to`,`expired`,`loc_id_master_account`,`master_account_code`,`master_account_name`,`cob_id_group_type`) VALUES (8,'patna','India',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1);
INSERT INTO `location` (`loc_id`,`location`,`location_description`,`lot_id`,`address`,`postcode`,`telephone`,`loc_id_primary_zone`,`primary_zone_code`,`primary_zone_desc`,`loc_id_secondary_zone`,`secondary_zone_code`,`secondary_zone_desc`,`loc_id_tertiary_zone`,`tertiary_zone_code`,`tertiary_zone_desc`,`loc_id_tv_station`,`tv_station_code`,`tv_station_name`,`loc_id_local_authority`,`local_authority_code`,`local_authority_name`,`loc_id_station_group`,`station_group`,`station_group_desc`,`loc_id_london_station_grp`,`london_station_grp_code`,`london_station_grp_desc`,`os_grid_reference`,`postal_region`,`nalco_12char_description`,`nalco_16char_description`,`nalco_26char_description`,`nalco_tiploc`,`nalco_3char_code`,`effective_from`,`effective_to`,`expired`,`loc_id_master_account`,`master_account_code`,`master_account_name`,`cob_id_group_type`) VALUES (331,'jaipur','India',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1);

INSERT INTO `ticket_allocation_code` (`tac_id`,`tac_code`,`tac_description`,`effective_from`,`effective_to`,`expired`) VALUES (1,'T',NULL,NULL,NULL,NULL);

INSERT INTO `ticket_class` (`tic_id`,`ticket_class_description`,`effective_from`,`effective_to`,`expired`) VALUES (1,'First Class',NULL,NULL,NULL);
INSERT INTO `product_type` (`prt_id`,`product_type_description`,`effective_from`,`effective_to`,`expired`) VALUES (1,'Product1',NULL,NULL,NULL);
INSERT INTO `product` (`pro_id`,`product_code`,`product_description`,`jof_journey_factor`,`pro_id_group_1`,`pro_group_1_code`,`pro_group_1_desc`,`pro_id_group_2`,`pro_group_2_code`,`pro_group_2_desc`,`expired`,`effective_from`,`effective_to`,`bus_id_corrective`,`exclude_from_ngt_sundries`,`business`,`prt_id`,`cob_id_debit_credit_type`,`cob_id_railcard_type`,`cob_id_suspendable_ind`,`tic_id`,`tac_id`) VALUES (1,'PROD1','Prd1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,1,1,1,1,1,1);
INSERT INTO `product` (`pro_id`,`product_code`,`product_description`,`jof_journey_factor`,`pro_id_group_1`,`pro_group_1_code`,`pro_group_1_desc`,`pro_id_group_2`,`pro_group_2_code`,`pro_group_2_desc`,`expired`,`effective_from`,`effective_to`,`bus_id_corrective`,`exclude_from_ngt_sundries`,`business`,`prt_id`,`cob_id_debit_credit_type`,`cob_id_railcard_type`,`cob_id_suspendable_ind`,`tic_id`,`tac_id`) VALUES (320,'PROD1','Prd1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,1,1,1,1,1,1);
INSERT INTO `product` (`pro_id`,`product_code`,`product_description`,`jof_journey_factor`,`pro_id_group_1`,`pro_group_1_code`,`pro_group_1_desc`,`pro_id_group_2`,`pro_group_2_code`,`pro_group_2_desc`,`expired`,`effective_from`,`effective_to`,`bus_id_corrective`,`exclude_from_ngt_sundries`,`business`,`prt_id`,`cob_id_debit_credit_type`,`cob_id_railcard_type`,`cob_id_suspendable_ind`,`tic_id`,`tac_id`) VALUES (118,'PROD1','Prd1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,1,1,1,1,1,1);

INSERT INTO `route` (`rou_id`,`expired`,`effective_from`,`effective_to`,`route_code`,`route_description`,`tac_id`,`cob_id_route_type`) VALUES (1,NULL,NULL,NULL,'RC1',NULL,1,1);
INSERT INTO `route` (`rou_id`,`expired`,`effective_from`,`effective_to`,`route_code`,`route_description`,`tac_id`,`cob_id_route_type`) VALUES (2545,NULL,NULL,NULL,'RC1',NULL,1,1);
INSERT INTO `route` (`rou_id`,`expired`,`effective_from`,`effective_to`,`route_code`,`route_description`,`tac_id`,`cob_id_route_type`) VALUES (320,NULL,NULL,NULL,'RC1',NULL,1,1);
INSERT INTO `ticket_status` (`tis_id`,`expired`,`effective_from`,`effective_to`,`ticket_status_code`,`ticket_status_description`,`percent_discount`,`rat_railcard_type_desc`,`ticket_status_type_desc`) VALUES (1,'N','2015-06-06','2016-06-06','ACT',NULL,NULL,NULL,NULL);


INSERT INTO `year` (`year`,`start_date`,`end_date`) VALUES (2015,'2015-01-01','2015-12-31');
INSERT INTO `period` (`per_id`,`year`,`period`,`start_date`,`end_date`,`status`,`period_mask`) VALUES (1,2015,2015,NULL,NULL,NULL,NULL);
INSERT INTO `week` (`week_id`,`week`,`start_date`,`end_date`,`week_mask`,`year`,`period`) VALUES (1,34,NULL,NULL,NULL,2015,1);
INSERT INTO `calendar` (`cal_id`,`calendar_date`,`day_of_week`,`period`,`year`,`week`,`currency_rate`,`conversion_power`) VALUES (1,'2015-10-10','10',1,2015,1,'334','22');

COMMIT;