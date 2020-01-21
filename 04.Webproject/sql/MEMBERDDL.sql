DROP TABLE member cascade constraint;

CREATE TABLE member (
       id             VARCHAR2(20)  PRIMARY KEY,
       pw              VARCHAR2(20) NOT NULL,
       name            VARCHAR2(20) NOT NULL,
       age              VARCHAR2(50) NOT NULL,
       sex             VARCHAR2(20) NOT NULL,
       birthday       VARCHAR2(20) NOT NULL,
       address       VARCHAR2(100) NOT NULL,
       job            VARCHAR2(50) NOT NULL,
       height       VARCHAR2(20) NOT NULL
);

DROP TABLE attach cascade constraint;

CREATE TABLE attach (
       id              VARCHAR2(20)  PRIMARY KEY,
		answer1		 	NUMBER(20) NOT NULL,
		answer2		 	NUMBER(20) NOT NULL,
		answer3		 	NUMBER(20) NOT NULL,
		answer4		 	NUMBER(20) NOT NULL,
		tot		 	NUMBER(20),
		type			 VARCHAR2(20) 
--	,
--		answer5			NUMBER(20) NOT NULL,
--		answer6			NUMBER(20) NOT NULL,
--		answer7			NUMBER(20) NOT NULL,
--		answer8			NUMBER(20) NOT NULL,
--		answer9			NUMBER(20) NOT NULL,
--		answer10			NUMBER(20) NOT NULL,
--		answer11			NUMBER(20) NOT NULL,
--		answer12			NUMBER(20) NOT NULL,
--		answer13			NUMBER(20) NOT NULL,
--		answer14			NUMBER(20) NOT NULL,
--		answer15			NUMBER(20) NOT NULL,
--		answer16			NUMBER(20) NOT NULL,
--		answer17			NUMBER(20) NOT NULL,
--		answer18			NUMBER(20) NOT NULL,
--		answer19			NUMBER(20) NOT NULL,
--		answer20			NUMBER(20) NOT NULL,
--		answer21			NUMBER(20) NOT NULL,
--		answer22			NUMBER(20) NOT NULL,
--		answer23			NUMBER(20) NOT NULL,
--		answer24			NUMBER(20) NOT NULL,
--		answer25			NUMBER(20) NOT NULL,
--		answer26			NUMBER(20) NOT NULL,
--		answer27			NUMBER(20) NOT NULL,
--		answer28			NUMBER(20) NOT NULL,
--		answer29			NUMBER(20) NOT NULL,
--		answer30			NUMBER(20) NOT NULL,
--		answer31			NUMBER(20) NOT NULL,
--		answer32			NUMBER(20) NOT NULL,
--		answer33			NUMBER(20) NOT NULL,
--		answer34			NUMBER(20) NOT NULL,
--		answer35			NUMBER(20) NOT NULL,
--		answer36			NUMBER(20) NOT NULL,
--		answer37			NUMBER(20) NOT NULL
);