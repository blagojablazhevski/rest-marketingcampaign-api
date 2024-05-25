# REST Marketing Campaign API
## Table of Contents
- [Introduction](#Introduction)
- [1. Target Audience](#1-target-audience)
    - [Target Audience Endpoints](#target-audience-endpoints)
        - [Create New Target Audience](#post-create-new-target-audience)
        - [Get All Target Audiences](#get-get-all-target-audiences)
        - [Get All Target Audiences By Id](#get-get-target-audience-by-id)
        - [Update Target Audience](#put-update-target-audience)
        - [Delete Target Audience](#put-update-target-audience)
- [2. Campaign](#2-campaign)
    - [Campaign Endpoints](#campaign-endpoints)
        - [Create New Campaign](#post-create-new-campaign)
        - [Get All Campaigns](#get-get-all-campaigns)
        - [Get Campaign By Id](#get-get-campaign-by-id)
        - [Get Campaigns By Name](#get-get-campaign-by-name)
        - [Get Campaigns By Region](#get-get-campaigns-by-region)
        - [Update Campaign](#put-update-campaign)
        - [Update Campaign Goal](#put-update-campaign-goal)
        - [Update Campaign Type](#put-update-campaign-type)
        - [Delete Campaign](#put-update-campaign-type)
- [3. Ads](#2-campaign)
    - [Ad Endpoints](#ad-endpoints)
        - [Create New Ad](#post-create-new-ad)
        - [Get All Ads](#get-get-all-ads)
        - [Get Ad By Id](#get-get-ad-by-id)
        - [Get Ads By Campaign](#get-get-ads-by-campaign)
        - [Get Ads By Region](#get-get-ads-by-region)
        - [Update Ad](#put-update-ad)
        - [Delete Ad](#delete-delete-ad)
- [4. Performance Tracking](#2-campaign)
    - [Performance Tracking Endpoints](#performance-tracking-endpoints)
        - [Get All Performance Trackings](#get-get-all-performance-trackings)
        - [Get Performance Tracking By Id](#get-get-performance-tracking-by-id)
        - [Get Performance Tracking By Ad](#get-get-performance-tracking-by-ad)
        - [Get Performance Trackings By Campaign](#get-get-performance-trackings-by-campaign)
        - [Update Performance Tracking By Id](#put-update-performance-tracking-by-id)
        - [Update Performance Tracking By Ad Id](#put-update-performance-tracking-by-ad-id)
- [5. Other](#5-other)
    - [Goal Endpoints](#goal-endpoints)
        - [Get All Goals](#get-get-all-goals)
        - [Get Goal By Id](#get-get-goal-by-id)
    - [Campaign Type Endpoints](#goal-endpoints)
        - [Get All Types](#get-get-all-campaign-types)
        - [Get Type By Id](#get-get-campaign-type-by-id)
## Introduction
Welcome to the documentation of my REST marketing campaign API, a project inspired by the functionality of Google Ads. I created this API as a part of my Computer Interface Programming class.

In this documentation, I have created an organized step-by-step "tutorial" that guides the user how through the entire process of creating a marketing campaign using this API. Starting with selecting a target audience, creating a name for the campaign as well as other important variables and creating individual ads within that campaign.

## Base URL
`http://localhost:8080/`

## Target Audience
Before creating a campaign, it is essential to define a target audience. The target audience specifies the demographic and geographic criteria for the ad campaign. The target audience includes details such as the region and age range of the intended audience.
The requests needed to create a target audience are shown below.

## Target Audience Endpoints

### `POST` Create New Target Audience

**Endpoint:** `/targetaudience`

**Description:** Creates a new target audience with the specified region and age range.

**Request Body:**
  ```json
  {
      "region": "MK",
      "ageRange": "18-21"
  }
  ```
- region - [ISO 3166-1 Alpha-2](<https://en.wikipedia.org/wiki/List_of_ISO_3166_country_codes> "Wikipedia page") representing the country.
- ageRange - Age range of the target audience in the format: minimum age-maximum age.

**Response Body:**

- **200 OK:**
  ```json
   {
      "targetingId": 1,
      "region": "MK",
      "ageRange": "18-24"
  }
    ```
- **400 Bad Request:** Invalid input
---
### `GET` Get All Target Audiences

**Endpoint:** `/targetaudience`

**Description:** Returns list of all target audiences.

**Response Body:**

- **200 OK:**
  ```json
  [
      {
          "targetingId": 1,
          "region": "MK",
          "ageRange": "18-24"
      },
      {
          "targetingId": 2,
          "region": "US",
          "ageRange": "18-24"
      }
  ]
  ```
- **204 No Content:** No issues found
---
### `GET` Get Target Audience By Id

**Endpoint:** `/targetaudience/{id}`

**Description:** Returns details of a specified target audience by **ID**.

**Path Parameters:**
- `id` (Long): The unique identifier of the target audience.

**Response Body:**

- **200 OK:**
  ```json
    {
        "targetingId": 2,
        "region": "US",
        "ageRange": "18-24"
    }
  ```
- **204 No Content:** No issues found
---
### `PUT` Update Target Audience

**Endpoint:** `/targetaudience/{id}`

**Description:** Updates the region and age-range of an existing target audience.

**Path Parameters:**
- `id` (Long): The unique identifier of the target audience.

**Request Body:**
```json
{
    "region": "CA",
    "ageRange": "16-24"
}
```

**Response Body:**

- **200 OK:**
    ```json
  {
      "region": "CA",
      "ageRange": "16-24"
  }
  ```
- **400 Bad Request:** Invalid input
- **404 Not Found:** Issue not found
---
### `DELETE` Delete Target Audience

**Endpoint:** `/targetaudience/{id}`

**Description:** Deletes the specified target audience by **ID**.

**Path Parameters:**
- `id` (Long): The unique identifier of the target audience.

**Responses:**

- **204 No Content:** Successfully closed
- **404 Not Found:** Issue not found

## Campaign
After sucessfully creating a target audience, a new ad campaign can be created.

Before creating a campaign there are 2 things to consider:
- Goal of the campaign:
  - Purchases (ID: 1) - Someone buys a product or service.
  - Submit Form (ID: 2) - Potential customer fills out a form.
  - Phone Call Lead (ID: 3) - Potential customer calls your business.
  - Page Views (ID: 4) - Someone views a key page (such as an article or product page.
  - Brand Awareness (ID: 5) - Reach a broad audience and build consideration for your brand.

- Campaign type:
  - Video (ID: 1) - Reach viewers on popular streaming platforms.
  - Display (ID: 2) - Reach customers across many sites and apps.
  - Smart (ID: 3) - Combined video and display solution, perfect for smaller businesses.

The ID of each goal/campaign can be checked anytime with the requests specified [here](#5-other).

## Campaign Endpoints

### `POST` Create New Campaign

**Endpoint:** `/campaign`

**Description:** Creates a new campaign using the specified query parameters and request body.

**Query parameters:**
- goalId (Long): The ID of the goal of the campaign.
- campaignTypeId (Long): The ID of the campaign type.
- targetAudienceId (Long): The ID of the target audience created for the campaign.

**Example URL:** `http://localhost:8080/campaign?goalId=4&campaignTypeId=2&targetAudienceId=1`

**Request Body:**
  ```json
   {
      "campaignName": "UACS: Dedicated to Your Future",
      "startDate": "2024-05-15",
      "endDate": "2024-06-15",
      "budget": 10000.00
  }
  ```
- campaignName - Name of the campaign.
- startDate and endDate - [ISO 8601](<https://en.wikipedia.org/wiki/ISO_8601> "Wikipedia page") in "YYYY-MM-DD" format, representing the start and end date of the campaign.
- budget - Total budget of the campaign.

**Response Body:**

- **200 OK:**
  ```json
  {
      "campaignId": 1,
      "campaignType": {
          "typeId": 2,
          "name": "Display",
          "description": "Reach customers across many sites and apps."
      },
      "goal": {
          "goal_id": 4,
          "name": "Page Views",
          "description": "Someone views a key page (such as an article or product page)."
      },
      "targetAudience": {
          "targetingId": 1,
          "region": "MK",
          "ageRange": "18-24"
      },
      "campaignName": "UACS: Dedicated to Your Future",
      "startDate": "2024-05-15",
      "endDate": "2024-06-15",
      "budget": 10000
  }
    ```
- **400 Bad Request:** Invalid input
---
### `GET` Get All Campaigns

**Endpoint:** `/campaign`

**Description:** Returns list of all campaigns.

**Response Body:**

- **200 OK:**
    ```json
    [
        {
            "campaignId": 1,
            "campaignType": {
                "typeId": 2,
                "name": "Display",
                "description": "Reach customers across many sites and apps."
            },
            "goal": {
                "goal_id": 4,
                "name": "Page Views",
                "description": "Someone views a key page (such as an article or product page)."
            },
            "targetAudience": {
                "targetingId": 1,
                "region": "MK",
                "ageRange": "18-24"
            },
            "campaignName": "UACS: Dedicated to Your Future",
            "startDate": "2024-05-15",
            "endDate": "2024-06-15",
            "budget": 10000
        },
        {
            "campaignId": 2,
            "campaignType": {
                "typeId": 2,
                "name": "Display",
                "description": "Reach customers across many sites and apps."
            },
            "goal": {
                "goal_id": 4,
                "name": "Page Views",
                "description": "Someone views a key page (such as an article or product page)."
            },
            "targetAudience": {
                "targetingId": 2,
                "region": "US",
                "ageRange": "18-24"
            },
            "campaignName": "MIT: Earth Day '24 ",
            "startDate": "2024-04-01",
            "endDate": "2024-04-22",
            "budget": 36320.5
        }
    ]
    ```
- **204 No Content:** No issues found
---
### `GET` Get Campaign By Id

**Endpoint:** `/campaign/{id}`

**Description:** Returns details of a specified campaign by **ID**.

**Path Parameters:**
- `id` (Long): The unique identifier of the campaign.

**Response Body:**

- **200 OK:**
    ```json
    {
        "campaignId": 2,
        "campaignType": {
            "typeId": 2,
            "name": "Display",
            "description": "Reach customers across many sites and apps."
        },
        "goal": {
            "goal_id": 4,
            "name": "Page Views",
            "description": "Someone views a key page (such as an article or product page)."
        },
        "targetAudience": {
            "targetingId": 2,
            "region": "US",
            "ageRange": "18-24"
        },
        "campaignName": "MIT: Earth Day '24 ",
        "startDate": "2024-04-01",
        "endDate": "2024-04-22",
        "budget": 36320.5
    }
    ```
- **204 No Content:** No issues found
---
### `GET` Get Campaign By Name

**Endpoint:** `/campaign/name/{string}`

**Description:** Returns a list of campaigns that contain the specified **string** in their name.

**Path Parameters:**
- `string` (String): The string to search for within campaign names.

**Example URL:** `localhost:8080/campaign/name/Earth`

**Response Body:**

- **200 OK:**
    ```json
    [
        {
            "campaignId": 2,
            "campaignType": {
                "typeId": 2,
                "name": "Display",
                "description": "Reach customers across many sites and apps."
            },
            "goal": {
                "goal_id": 4,
                "name": "Page Views",
                "description": "Someone views a key page (such as an article or product page)."
            },
            "targetAudience": {
                "targetingId": 2,
                "region": "US",
                "ageRange": "18-24"
            },
            "campaignName": "MIT: Earth Day '24 ",
            "startDate": "2024-04-01",
            "endDate": "2024-04-22",
            "budget": 36320.5
        }
    ]
    ```
- **204 No Content:** No issues found
---
### `GET` Get Campaigns By Region

**Endpoint:** `/campaign/region/{string}`

**Description:** Returns a list of campaigns that are created for the specified **region**.

**Example URL:** `localhost:8080/campaign/region/MK`

**Path Parameters:**
- `string` (String): The string to search for within campaign regions.

**Response Body:**

- **200 OK:**
    ```json
    [
        {
            "campaignId": 1,
            "campaignType": {
                "typeId": 2,
                "name": "Display",
                "description": "Reach customers across many sites and apps."
            },
            "goal": {
                "goal_id": 4,
                "name": "Page Views",
                "description": "Someone views a key page (such as an article or product page)."
            },
            "targetAudience": {
                "targetingId": 1,
                "region": "MK",
                "ageRange": "18-24"
            },
            "campaignName": "UACS: Dedicated to Your Future",
            "startDate": "2024-05-15",
            "endDate": "2024-06-15",
            "budget": 10000
        }
    ]
    ```
- **204 No Content:** No issues found
---
### `PUT` Update Campaign

**Endpoint:** `/campaign/{id}`

**Description:** Updates the name, start and end date and budget of a campaign by **ID**.

**Path Parameters:**
- `id` (Long): The unique identifier of the campaign.

**Request Body:**
```json
{
    "campaignName": "UACS: Master your Future",
    "startDate": "2024-06-01",
    "endDate": "2024-08-30",
    "budget": 12500.75
}
```

**Response Body:**

- **200 OK:**
    ```json
    {
        "campaignId": 1,
        "campaignType": {
            "typeId": 2,
            "name": "Display",
            "description": "Reach customers across many sites and apps."
        },
        "goal": {
            "goal_id": 4,
            "name": "Page Views",
            "description": "Someone views a key page (such as an article or product page)."
        },
        "targetAudience": {
            "targetingId": 1,
            "region": "MK",
            "ageRange": "18-24"
        },
        "campaignName": "UACS: Master your Future",
        "startDate": "2024-06-01",
        "endDate": "2024-08-30",
        "budget": 12500.75
    }
    ```
- **400 Bad Request:** Invalid input
- **404 Not Found:** Issue not found
---
### `PUT` Update Campaign Goal

**Endpoint:** `/campaign/{campaignid}/goal/{goalid}`

**Description:** Updates the goal of a campaign by **ID**.

**Path Parameters:**
- `campaignid` (Long): The unique identifier of the campaign.
- `goalid` (Long): The unique identifier of the goal.

**Example URL:** `localhost:8080/campaign/1/goal/2`

**Response Body:**

- **200 OK:**
    ```json
    {
        "campaignId": 1,
        "campaignType": {
            "typeId": 2,
            "name": "Display",
            "description": "Reach customers across many sites and apps."
        },
        "goal": {
            "goal_id": 2,
            "name": "Submit Form",
            "description": "Potential customer fills out a form."
        },
        "targetAudience": {
            "targetingId": 1,
            "region": "MK",
            "ageRange": "18-24"
        },
        "campaignName": "UACS: Dedicated to Your Future",
        "startDate": "2024-05-15",
        "endDate": "2024-06-15",
        "budget": 10000
    }
    ```
- **400 Bad Request:** Invalid input
- **404 Not Found:** Issue not found
---
### `PUT` Update Campaign Type

**Endpoint:** `/campaign/{campaignid}/type/{typeid}`

**Description:** Updates the goal of a type by **ID**.

**Path Parameters:**
- `campaignid` (Long): The unique identifier of the campaign.
- `typeid` (Long): The unique identifier of the campaign type.

**Example URL:** `localhost:8080/campaign/1/type/3`

**Response Body:**

- **200 OK:**
    ```json
    {
        "campaignId": 1,
        "campaignType": {
            "typeId": 3,
            "name": "Smart",
            "description": "Combined video and display solution, perfect for smaller businesses."
        },
        "goal": {
            "goal_id": 2,
            "name": "Submit Form",
            "description": "Potential customer fills out a form."
        },
        "targetAudience": {
            "targetingId": 1,
            "region": "MK",
            "ageRange": "18-24"
        },
        "campaignName": "UACS: Dedicated to Your Future",
        "startDate": "2024-05-15",
        "endDate": "2024-06-15",
        "budget": 10000.00
    }
    ```
- **400 Bad Request:** Invalid input
- **404 Not Found:** Issue not found
---
### `DELETE` Delete Campaign

**Endpoint:** `/campaign/{id}`

**Description:** Deletes the specified campaign by **ID**.

**Path Parameters:**
- `id` (Long): The unique identifier of the campaign.

**Responses:**

- **204 No Content:** Successfully closed
- **404 Not Found:** Issue not found

## Ads
The Ad Entity represents a single advertisement within a marketing campaign. Once a marketing campaign is created, users can proceed to create individual ads associated with that campaign.

## Ad Endpoints

### `POST` Create New Ad

**Endpoint:** `/ad`

**Description:** Creates a new ad using the specified query parameters and request body.

**Query parameters:**
- campaignId (Long): The ID of the campaign.

**Example URL:** `localhost:8080/ad?campaignId=1`

**Request Body:**
```json
{
    "headline": "UACS: A Legacy of Excellence",
    "description": "UACS is the only internationally accredited University in Republic of Macedonia. It is supported by the Business Council which consists of more than 150 companies organizations and institutions - which provides guest lectures and internships for students",
    "mediaUrl": "https://www.youtube.com/watch?v=fZ4TFef2v4k"
}
```
- headline - The headline of the ad.
- description - The description of the ad.
- mediaUrl - Link to the image/video associated with the ad.

**Response Body:**

- **200 OK:**
    ```json
    {
        "adId": 1,
        "campaign": {
            "campaignId": 1,
            "campaignType": {
                "typeId": 3,
                "name": "Smart",
                "description": "Combined video and display solution, perfect for smaller businesses."
            },
            "goal": {
                "goal_id": 2,
                "name": "Submit Form",
                "description": "Potential customer fills out a form."
            },
            "targetAudience": {
                "targetingId": 1,
                "region": "MK",
                "ageRange": "18-24"
            },
            "campaignName": "UACS: Dedicated to Your Future",
            "startDate": "2024-05-15",
            "endDate": "2024-06-15",
            "budget": 10000
        },
        "headline": "UACS: A Legacy of Excellence",
        "description": "UACS is the only internationally accredited University in Republic of Macedonia. It is supported by the Business Council which consists of more than 150 companies organizations and institutions - which provides guest lectures and internships for students",
        "mediaUrl": "https://www.youtube.com/watch?v=fZ4TFef2v4k"
    }
    ```
- **400 Bad Request:** Invalid input
---
### `GET` Get All Ads

**Endpoint:** `/ad`

**Description:** Returns list of all ads.

**Response Body:**

- **200 OK:**
    ```json
    [
        {
            "adId": 1,
            "campaign": {
                "campaignId": 1,
                "campaignType": {
                    "typeId": 3,
                    "name": "Smart",
                    "description": "Combined video and display solution, perfect for smaller businesses."
                },
                "goal": {
                    "goal_id": 2,
                    "name": "Submit Form",
                    "description": "Potential customer fills out a form."
                },
                "targetAudience": {
                    "targetingId": 1,
                    "region": "MK",
                    "ageRange": "18-24"
                },
                "campaignName": "UACS: Dedicated to Your Future",
                "startDate": "2024-05-15",
                "endDate": "2024-06-15",
                "budget": 10000.00
            },
            "headline": "UACS: Dedicated to Your Future",
            "description": "Enroll NOW for the 2024/2025 academic year and ignite your journey to success!",
            "mediaUrl": "https://www.instagram.com/p/C3hyy2oMOsC/"
        },
        {
            "adId": 2,
            "campaign": {
                "campaignId": 1,
                "campaignType": {
                    "typeId": 3,
                    "name": "Smart",
                    "description": "Combined video and display solution, perfect for smaller businesses."
                },
                "goal": {
                    "goal_id": 2,
                    "name": "Submit Form",
                    "description": "Potential customer fills out a form."
                },
                "targetAudience": {
                    "targetingId": 1,
                    "region": "MK",
                    "ageRange": "18-24"
                },
                "campaignName": "UACS: Dedicated to Your Future",
                "startDate": "2024-05-15",
                "endDate": "2024-06-15",
                "budget": 10000.00
            },
            "headline": "Unlock your future with UACS",
            "description": "Enroll NOW for the 2024/2025 academic year and ignite your journey to success! More info at - uacs.edu.mk/home/calls-for-enrollment",
            "mediaUrl": "https://www.instagram.com/p/C3hyy2oMOsC/"
        }
    ]
    ```
- **204 No Content:** No issues found
---
### `GET` Get Ad By Id

**Endpoint:** `/ad/{id}`

**Description:** Returns details of a specified ad by **ID**.

**Path Parameters:**
- `id` (Long): The unique identifier of the ad.

**Response Body:**

- **200 OK:**
    ```json
    {
        "adId": 1,
        "campaign": {
            "campaignId": 1,
            "campaignType": {
                "typeId": 3,
                "name": "Smart",
                "description": "Combined video and display solution, perfect for smaller businesses."
            },
            "goal": {
                "goal_id": 2,
                "name": "Submit Form",
                "description": "Potential customer fills out a form."
            },
            "targetAudience": {
                "targetingId": 1,
                "region": "MK",
                "ageRange": "18-24"
            },
            "campaignName": "UACS: Dedicated to Your Future",
            "startDate": "2024-05-15",
            "endDate": "2024-06-15",
            "budget": 10000.00
        },
        "headline": "UACS: Dedicated to Your Future",
        "description": "Enroll NOW for the 2024/2025 academic year and ignite your journey to success!",
        "mediaUrl": "https://www.instagram.com/p/C3hyy2oMOsC/"
    }
    ```
- **204 No Content:** No issues found
---
### `GET` Get Ads By Campaign

**Endpoint:** `/ad/campaign/{campaignid}`

**Description:** Returns a list of ads that are created for the specified **campaign**.

**Example URL:** `localhost:8080/ad/campaign/1`

**Path Parameters:**
- `id` (Long): The unique identifier of the campaign.

**Response Body:**

- **200 OK:**
    ```json
    [
        {
            "adId": 1,
            "campaign": {
                "campaignId": 1,
                "campaignType": {
                    "typeId": 3,
                    "name": "Smart",
                    "description": "Combined video and display solution, perfect for smaller businesses."
                },
                "goal": {
                    "goal_id": 2,
                    "name": "Submit Form",
                    "description": "Potential customer fills out a form."
                },
                "targetAudience": {
                    "targetingId": 1,
                    "region": "MK",
                    "ageRange": "18-24"
                },
                "campaignName": "UACS: Dedicated to Your Future",
                "startDate": "2024-05-15",
                "endDate": "2024-06-15",
                "budget": 10000.00
            },
            "headline": "UACS: Dedicated to Your Future",
            "description": "Enroll NOW for the 2024/2025 academic year and ignite your journey to success!",
            "mediaUrl": "https://www.instagram.com/p/C3hyy2oMOsC/"
        },
        {
            "adId": 2,
            "campaign": {
                "campaignId": 1,
                "campaignType": {
                    "typeId": 3,
                    "name": "Smart",
                    "description": "Combined video and display solution, perfect for smaller businesses."
                },
                "goal": {
                    "goal_id": 2,
                    "name": "Submit Form",
                    "description": "Potential customer fills out a form."
                },
                "targetAudience": {
                    "targetingId": 1,
                    "region": "MK",
                    "ageRange": "18-24"
                },
                "campaignName": "UACS: Dedicated to Your Future",
                "startDate": "2024-05-15",
                "endDate": "2024-06-15",
                "budget": 10000.00
            },
            "headline": "Unlock your future with UACS",
            "description": "Enroll NOW for the 2024/2025 academic year and ignite your journey to success! More info at - uacs.edu.mk/home/calls-for-enrollment",
            "mediaUrl": "https://www.instagram.com/p/C3hyy2oMOsC/"
        }
    ]
    ```
- **204 No Content:** No issues found
---
### `GET` Get Ads By Region

**Endpoint:** `/ad/region/{string}`

**Description:** Returns a list of ads that are created for the specified **region**.

**Example URL:** `localhost:8080/ad/region/MK`

**Path Parameters:**
- `string` (String): The string to search for within ad regions.

**Response Body:**

- **200 OK:**
    ```json
    [
        {
            "campaignId": 1,
            "campaignType": {
                "typeId": 3,
                "name": "Smart",
                "description": "Combined video and display solution, perfect for smaller businesses."
            },
            "goal": {
                "goal_id": 2,
                "name": "Submit Form",
                "description": "Potential customer fills out a form."
            },
            "targetAudience": {
                "targetingId": 1,
                "region": "MK",
                "ageRange": "18-24"
            },
            "campaignName": "UACS: Dedicated to Your Future",
            "startDate": "2024-05-15",
            "endDate": "2024-06-15",
            "budget": 10000.00
        }
    ]
    ```
- **204 No Content:** No issues found
---
### `PUT` Update Ad

**Endpoint:** `/ad/{id}`

**Description:** Updates the headline, description and media url of an ad by **ID**.

**Path Parameters:**
- `id` (Long): The unique identifier of the ad.

**Request Body:**
```json
{
    "headline": "UACS: Dedicated to Your Future",
    "description": "Enroll NOW for the 2024/2025 academic year and ignite your journey to success!",
    "mediaUrl": "https://www.instagram.com/p/C3hyy2oMOsC/"
}
```

**Response Body:**

- **200 OK:**
    ```json
    {
        "adId": 1,
        "campaign": {
            "campaignId": 1,
            "campaignType": {
                "typeId": 3,
                "name": "Smart",
                "description": "Combined video and display solution, perfect for smaller businesses."
            },
            "goal": {
                "goal_id": 2,
                "name": "Submit Form",
                "description": "Potential customer fills out a form."
            },
            "targetAudience": {
                "targetingId": 1,
                "region": "MK",
                "ageRange": "18-24"
            },
            "campaignName": "UACS: Dedicated to Your Future",
            "startDate": "2024-05-15",
            "endDate": "2024-06-15",
            "budget": 10000.00
        },
        "headline": "UACS: Dedicated to Your Future",
        "description": "Enroll NOW for the 2024/2025 academic year and ignite your journey to success!",
        "mediaUrl": "https://www.instagram.com/p/C3hyy2oMOsC/"
    }
    ```
- **400 Bad Request:** Invalid input
- **404 Not Found:** Issue not found
---
### `DELETE` Delete Ad

**Endpoint:** `/ad/{id}`

**Description:** Deletes the specified ad by **ID**.

**Path Parameters:**
- `id` (Long): The unique identifier of the d

**Responses:**

- **204 No Content:** Successfully closed
- **404 Not Found:** Issue not found

## Performance Tracking
Upon ad creation, a corresponding performance tracking table is automatically generated. For this reason manual tracking creation or deletion is prohibited.
While POST/DELETE operations are restricted, GET and PUT requests are available for viewing and updating ad performance.

## Performance Tracking Endpoints

### `GET` Get All Performance Trackings

**Endpoint:** `/tracking`

**Description:** Returns list of all performance trackings.

**Response Body:**

- **200 OK:**
    ```json
    [
        {
            "trackingId": 1,
            "ad": {
                "adId": 1,
                "campaign": {
                    "campaignId": 1,
                    "campaignType": {
                        "typeId": 3,
                        "name": "Smart",
                        "description": "Combined video and display solution, perfect for smaller businesses."
                    },
                    "goal": {
                        "goal_id": 2,
                        "name": "Submit Form",
                        "description": "Potential customer fills out a form."
                    },
                    "targetAudience": {
                        "targetingId": 1,
                        "region": "MK",
                        "ageRange": "18-24"
                    },
                    "campaignName": "UACS: Dedicated to Your Future",
                    "startDate": "2024-05-15",
                    "endDate": "2024-06-15",
                    "budget": 10000.00
                },
                "headline": "UACS: Dedicated to Your Future",
                "description": "Enroll NOW for the 2024/2025 academic year and ignite your journey to success!",
                "mediaUrl": "https://www.instagram.com/p/C3hyy2oMOsC/"
            },
            "clicks": 0,
            "impressions": 0,
            "cost": 0.00,
            "costPerClick": 0.00
        },
        {
            "trackingId": 2,
            "ad": {
                "adId": 2,
                "campaign": {
                    "campaignId": 1,
                    "campaignType": {
                        "typeId": 3,
                        "name": "Smart",
                        "description": "Combined video and display solution, perfect for smaller businesses."
                    },
                    "goal": {
                        "goal_id": 2,
                        "name": "Submit Form",
                        "description": "Potential customer fills out a form."
                    },
                    "targetAudience": {
                        "targetingId": 1,
                        "region": "MK",
                        "ageRange": "18-24"
                    },
                    "campaignName": "UACS: Dedicated to Your Future",
                    "startDate": "2024-05-15",
                    "endDate": "2024-06-15",
                    "budget": 10000.00
                },
                "headline": "Unlock your future with UACS",
                "description": "Enroll NOW for the 2024/2025 academic year and ignite your journey to success! More info at - uacs.edu.mk/home/calls-for-enrollment",
                "mediaUrl": "https://www.instagram.com/p/C3hyy2oMOsC/"
            },
            "clicks": 0,
            "impressions": 0,
            "cost": 0.00,
            "costPerClick": 0.00
        }
    ]
    ```
- **204 No Content:** No issues found
---
### `GET` Get Performance Tracking By Id

**Endpoint:** `/tracking/{id}`

**Description:** Returns details of specified tracking by **ID**.

**Path Parameters:**
- `id` (Long): The unique identifier of the tracking.

**Response Body:**

- **200 OK:**
    ```json
    {
        "trackingId": 1,
        "ad": {
            "adId": 1,
            "campaign": {
                "campaignId": 1,
                "campaignType": {
                    "typeId": 3,
                    "name": "Smart",
                    "description": "Combined video and display solution, perfect for smaller businesses."
                },
                "goal": {
                    "goal_id": 2,
                    "name": "Submit Form",
                    "description": "Potential customer fills out a form."
                },
                "targetAudience": {
                    "targetingId": 1,
                    "region": "MK",
                    "ageRange": "18-24"
                },
                "campaignName": "UACS: Dedicated to Your Future",
                "startDate": "2024-05-15",
                "endDate": "2024-06-15",
                "budget": 10000.00
            },
            "headline": "UACS: Dedicated to Your Future",
            "description": "Enroll NOW for the 2024/2025 academic year and ignite your journey to success!",
            "mediaUrl": "https://www.instagram.com/p/C3hyy2oMOsC/"
        },
        "clicks": 0,
        "impressions": 0,
        "cost": 0.00,
        "costPerClick": 0.00
    }
    ```
- **204 No Content:** No issues found
---
### `GET` Get Performance Tracking By Ad

**Endpoint:** `/tracking/ad/{adid}`

**Description:** Returns details of specified tracking by **ad ID**.

**Example URL:** `localhost:8080/tracking/ad/2`

**Path Parameters:**
- `adid` (Long): The unique identifier of the ad.

**Response Body:**

- **200 OK:**
    ```json
    {
        "trackingId": 2,
        "ad": {
            "adId": 2,
            "campaign": {
                "campaignId": 1,
                "campaignType": {
                    "typeId": 3,
                    "name": "Smart",
                    "description": "Combined video and display solution, perfect for smaller businesses."
                },
                "goal": {
                    "goal_id": 2,
                    "name": "Submit Form",
                    "description": "Potential customer fills out a form."
                },
                "targetAudience": {
                    "targetingId": 1,
                    "region": "MK",
                    "ageRange": "18-24"
                },
                "campaignName": "UACS: Dedicated to Your Future",
                "startDate": "2024-05-15",
                "endDate": "2024-06-15",
                "budget": 10000.00
            },
            "headline": "Unlock your future with UACS",
            "description": "Enroll NOW for the 2024/2025 academic year and ignite your journey to success! More info at - uacs.edu.mk/home/calls-for-enrollment",
            "mediaUrl": "https://www.instagram.com/p/C3hyy2oMOsC/"
        },
        "clicks": 0,
        "impressions": 0,
        "cost": 0.00,
        "costPerClick": 0.00
    }
    ```
- **204 No Content:** No issues found
---
### `GET` Get Performance Trackings By Campaign

**Endpoint:** `/tracking/campaign/{campaignid}`

**Description:** Returns a list of performance trackings that belong to a certain **campaign**.

**Example URL:** `localhost:8080/tracking/campaign/1`

**Path Parameters:**
- `campaignid` (Long): The unique identifier of the campaign.

**Response Body:**

- **200 OK:**
    ```json
    [
        {
            "trackingId": 1,
            "ad": {
                "adId": 1,
                "campaign": {
                    "campaignId": 1,
                    "campaignType": {
                        "typeId": 3,
                        "name": "Smart",
                        "description": "Combined video and display solution, perfect for smaller businesses."
                    },
                    "goal": {
                        "goal_id": 2,
                        "name": "Submit Form",
                        "description": "Potential customer fills out a form."
                    },
                    "targetAudience": {
                        "targetingId": 1,
                        "region": "MK",
                        "ageRange": "18-24"
                    },
                    "campaignName": "UACS: Dedicated to Your Future",
                    "startDate": "2024-05-15",
                    "endDate": "2024-06-15",
                    "budget": 10000.00
                },
                "headline": "UACS: Dedicated to Your Future",
                "description": "Enroll NOW for the 2024/2025 academic year and ignite your journey to success!",
                "mediaUrl": "https://www.instagram.com/p/C3hyy2oMOsC/"
            },
            "clicks": 0,
            "impressions": 0,
            "cost": 0.00,
            "costPerClick": 0.00
        },
        {
            "trackingId": 2,
            "ad": {
                "adId": 2,
                "campaign": {
                    "campaignId": 1,
                    "campaignType": {
                        "typeId": 3,
                        "name": "Smart",
                        "description": "Combined video and display solution, perfect for smaller businesses."
                    },
                    "goal": {
                        "goal_id": 2,
                        "name": "Submit Form",
                        "description": "Potential customer fills out a form."
                    },
                    "targetAudience": {
                        "targetingId": 1,
                        "region": "MK",
                        "ageRange": "18-24"
                    },
                    "campaignName": "UACS: Dedicated to Your Future",
                    "startDate": "2024-05-15",
                    "endDate": "2024-06-15",
                    "budget": 10000.00
                },
                "headline": "Unlock your future with UACS",
                "description": "Enroll NOW for the 2024/2025 academic year and ignite your journey to success! More info at - uacs.edu.mk/home/calls-for-enrollment",
                "mediaUrl": "https://www.instagram.com/p/C3hyy2oMOsC/"
            },
            "clicks": 0,
            "impressions": 0,
            "cost": 0.00,
            "costPerClick": 0.00
        }
    ]
    ```
- **204 No Content:** No issues found
---
### `PUT` Update Performance Tracking By Id

**Endpoint:** `/tracking/{id}`

**Description:** Updates the clicks, impressions and cost of an existing tracking by **ID**.

**Path Parameters:**
- `id` (Long): The unique identifier of the tracking.

**Request Body:**
```json
{
    "clicks": 24251,
    "impressions": 30121,
    "cost": 36346.57
}
```

**Response Body:**

- **200 OK:**
    ```json
    {
        "trackingId": 1,
        "ad": {
            "adId": 1,
            "campaign": {
                "campaignId": 1,
                "campaignType": {
                    "typeId": 3,
                    "name": "Smart",
                    "description": "Combined video and display solution, perfect for smaller businesses."
                },
                "goal": {
                    "goal_id": 2,
                    "name": "Submit Form",
                    "description": "Potential customer fills out a form."
                },
                "targetAudience": {
                    "targetingId": 1,
                    "region": "MK",
                    "ageRange": "18-24"
                },
                "campaignName": "UACS: Dedicated to Your Future",
                "startDate": "2024-05-15",
                "endDate": "2024-06-15",
                "budget": 10000.00
            },
            "headline": "UACS: Dedicated to Your Future",
            "description": "Enroll NOW for the 2024/2025 academic year and ignite your journey to success!",
            "mediaUrl": "https://www.instagram.com/p/C3hyy2oMOsC/"
        },
        "clicks": 24251,
        "impressions": 30121,
        "cost": 36346.57,
        "costPerClick": 1.50
    }
    ```
- **400 Bad Request:** Invalid input
- **404 Not Found:** Issue not found
---
### `PUT` Update Performance Tracking By Ad Id

**Endpoint:** `/tracking/ad/{adid}`

**Description:** Updates the clicks, impressions and cost of an existing tracking associated with the **ad ID**.

**Path Parameters:**
- `adid` (Long): The unique identifier of the ad.

**Request Body:**
```json
{
    "clicks": 10,
    "impressions": 21,
    "cost": 5.00
}
```

**Response Body:**

- **200 OK:**
    ```json
    {
        "trackingId": 2,
        "ad": {
            "adId": 2,
            "campaign": {
                "campaignId": 1,
                "campaignType": {
                    "typeId": 3,
                    "name": "Smart",
                    "description": "Combined video and display solution, perfect for smaller businesses."
                },
                "goal": {
                    "goal_id": 2,
                    "name": "Submit Form",
                    "description": "Potential customer fills out a form."
                },
                "targetAudience": {
                    "targetingId": 1,
                    "region": "MK",
                    "ageRange": "18-24"
                },
                "campaignName": "UACS: Dedicated to Your Future",
                "startDate": "2024-05-15",
                "endDate": "2024-06-15",
                "budget": 10000.00
            },
            "headline": "Unlock your future with UACS",
            "description": "Enroll NOW for the 2024/2025 academic year and ignite your journey to success! More info at - uacs.edu.mk/home/calls-for-enrollment",
            "mediaUrl": "https://www.instagram.com/p/C3hyy2oMOsC/"
        },
        "clicks": 10,
        "impressions": 21,
        "cost": 5.00,
        "costPerClick": 0.50
    }
    ```
- **400 Bad Request:** Invalid input
- **404 Not Found:** Issue not found

## Other
This section covers entities that have too few endpoints to have their own category. These entities include **Goal** and **Campaign Type**, which are with predefined values. They are not modifiable and can only be accessed through GET methods. These entities are essential for defining the objectives and classifications of marketing campaigns.

## Goal Endpoints

### `GET` Get All Goals

**Endpoint:** `/goal`

**Description:** Returns list of all campaign goals.

**Response Body:**

- **200 OK:**
     ```json
    [
        {
            "goal_id": 1,
            "name": "Purchases",
            "description": "Someone buys a product or service."
        },
        {
            "goal_id": 2,
            "name": "Submit Form",
            "description": "Potential customer fills out a form."
        },
        {
            "goal_id": 3,
            "name": "Phone Call Lead",
            "description": "Potential customer calls your business."
        },
        {
            "goal_id": 4,
            "name": "Page Views",
            "description": "Someone views a key page (such as an article or product page)."
        },
        {
            "goal_id": 5,
            "name": "Brand Awareness",
            "description": "Reach a broad audience and build consideration for your brand."
        }
    ]
     ```
- **204 No Content:** No issues found
---
### `GET` Get Goal By Id

**Endpoint:** `/goal/{id}`

**Description:** Returns details of a specified campaign goal by **ID**.

**Path Parameters:**
- `id` (Long): The unique identifier of the campaign goal.

**Response Body:**

- **200 OK:**
  ```json
    {
        "goal_id": 3,
        "name": "Phone Call Lead",
        "description": "Potential customer calls your business."
    }
  ```
- **204 No Content:** No issues found

## Campaign Type Endpoints

### `GET` Get All Campaign Types

**Endpoint:** `/campaigntype`

**Description:** Returns list of all campaign types.

**Response Body:**

- **200 OK:**
    ```json
        [
        {
            "typeId": 1,
            "name": "Video",
            "description": "Reach viewers on popular streaming platforms."
        },
        {
            "typeId": 2,
            "name": "Display",
            "description": "Reach customers across many sites and apps."
        },
        {
            "typeId": 3,
            "name": "Smart",
            "description": "Combined video and display solution, perfect for smaller businesses."
        }
    ]
    ```
- **204 No Content:** No issues found
---
### `GET` Get Campaign Type By Id

**Endpoint:** `/campaigntype/{id}`

**Description:** Returns details of a specified campaign type by **ID**.

**Path Parameters:**
- `id` (Long): The unique identifier of the campaign type.

**Response Body:**

- **200 OK:**
    ```json
    {
        "typeId": 2,
        "name": "Display",
        "description": "Reach customers across many sites and apps."
    }
    ```
- **204 No Content:** No issues found
