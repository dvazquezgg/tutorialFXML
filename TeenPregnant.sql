BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "ConsultancyRecords" (
	"id"	INTEGER,
	"Name"	TEXT NOT NULL,
	"Surname"	TEXT NOT NULL,
	"Pregnant"	BOOLEAN NOT NULL CHECK("Pregnant" IN (0, 1)),
	"Days"	TEXT NOT NULL,
	"ConsultancyType"	TEXT NOT NULL,
	PRIMARY KEY("id" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "Donations" (
	"id"	INTEGER NOT NULL UNIQUE,
	"Name"	TEXT NOT NULL,
	"Phone"	TEXT,
	"Email"	INTEGER NOT NULL,
	"DonationType"	TEXT NOT NULL,
	"Volunteer"	TEXT NOT NULL,
	"MoneyValue"	NUMERIC,
	PRIMARY KEY("id" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "MedicalAppointmentPostNatal" (
	"id"	INTEGER NOT NULL UNIQUE,
	"PatientID"	INTEGER NOT NULL,
	"WeeksAfter"	INTEGER NOT NULL,
	"Checkup"	TEXT NOT NULL,
	PRIMARY KEY("id" AUTOINCREMENT),
	FOREIGN KEY("PatientID") REFERENCES "ConsultancyRecords"("id")
);
CREATE TABLE IF NOT EXISTS "MedicalAppointMentPregnant" (
	"id"	INTEGER NOT NULL UNIQUE,
	"PatientID"	INTEGER NOT NULL,
	"Weeks"	INTEGER NOT NULL,
	"Symptoms"	TEXT NOT NULL,
	"Medication"	TEXT,
	PRIMARY KEY("id" AUTOINCREMENT),
	FOREIGN KEY("PatientID") REFERENCES "ConsultancyRecords"("id")
);
CREATE TABLE IF NOT EXISTS "MedicalAppointmentNonPreg" (
	"id"	INTEGER NOT NULL UNIQUE,
	"PatientID"	INTEGER NOT NULL,
	"Reason"	TEXT NOT NULL,
	PRIMARY KEY("id" AUTOINCREMENT),
	FOREIGN KEY("PatientID") REFERENCES "ConsultancyRecords"("id")
);
CREATE TABLE IF NOT EXISTS "Shelter" (
	"id"	INTEGER NOT NULL UNIQUE,
	"PatientID"	INTEGER NOT NULL,
	"Reason"	TEXT NOT NULL,
	"County"	INTEGER NOT NULL,
	"People"	INTEGER NOT NULL,
	"ExtraNeeds"	TEXT,
	"Redirect"	TEXT,
	"Clothes"	INTEGER NOT NULL,
	PRIMARY KEY("id" AUTOINCREMENT),
	FOREIGN KEY("PatientID") REFERENCES "ConsultancyRecords"("id")
);
INSERT INTO "ConsultancyRecords" ("id","Name","Surname","Pregnant","Days","ConsultancyType") VALUES (1,'Daniel','Vazquez',1,'Tue,Thu,','Medical');
INSERT INTO "ConsultancyRecords" ("id","Name","Surname","Pregnant","Days","ConsultancyType") VALUES (2,'Pau','Crisostomo',1,'Mon,Wed,Fri,','Shelter');
INSERT INTO "ConsultancyRecords" ("id","Name","Surname","Pregnant","Days","ConsultancyType") VALUES (3,'Daniel','Vazquez',0,'Fri,','Counselling');
COMMIT;
