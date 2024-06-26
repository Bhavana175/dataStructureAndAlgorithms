package com.workspace.learning.interviews.paypalpractice.sysdesign;

public class GoFundMeCampaignApp {


    /*

   Q: Create Go fund me System Design
   --> user can create campaign to fund a cause.
   --> collect money for the cause

   Actors
   Registered user

   Functional Requirements
   1. User Registration (will define criteria)
   2. Creator can Create Campaign to fund the cause.
   3. User can donate/contribute the Money against Campaign.
   4. Creator can collect the money against the Campaign.
   5. View Campaign by id
   6. Once a day money is transferred to Creators account.

    Non - Functional Requirement
    1. Scalable
    2. Highly Available
    3. Data consistency
    4. low latency

    Estimation (Request per sec )

    Contribution request expecting in a day : 100000 req/day
    1.1 req per sec = 2 req/sec

    Creator
    POST: v1/api/campaign     requestBody :

     {
     "Name":"",
      cause:"",
      description:"",

     }
     response {
     campaignId :
     }
-----------------------------------------
    GET  api/v1/campaign/{id}
    -------------------------------
    POST api/v1/campaign/{id}/payment
    RequestBody{
    contribution Amount:
    }

    Response
    {
    payment id :
    }
----------------------------------

     Creator
     -----------------------
     GET : api/v1/campaign/{id}/collection
     response{
     total amount collected :
     }


     low level design

     Class User{
     String userId PK
     name
     password
     role: CREATOR/STANDARD_USER
     }

     Class Campaign {
        String campaignId; PK
        String name;
        String cause;
        String Description;
     }


    Payment {
    String paymentId PK
    String CampaignId ; FK
    Double amount ;
    PaymentMode mode;
    }

    Notification Service
    notify for successful payment and other events
---------------------------------------------------------------------------
*/




}
