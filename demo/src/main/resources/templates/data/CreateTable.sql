CREATE TABLE "MYLOCAL"."COMMENTINGS" 
   (	"ID" NUMBER, 
	"POSTCOMMENT" VARCHAR2(1000 BYTE), 
	"REPLY" NUMBER, 
	 PRIMARY KEY ("ID"),
      FOREIGN KEY ("REPLY")
	  REFERENCES "MYLOCAL"."COMMENTINGS" ("ID"));
