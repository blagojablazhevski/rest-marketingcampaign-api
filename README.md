# REST Marketing Campaign API

## Introduction
Welcome to the documentation of my REST marketing campaign API, a project inspired by the functionality of Google Ads. I created this API as a part of my Computer Interface Programming class.

In this documentation, I have created an organized step-by-step "tutorial" that guides the user how through the entire process of creating a marketing campaign using this API. Starting with selecting a target audience, creating a name for the campaign as well as other important variables and creating individual ads within that campaign.

## Base URL
`http://localhost:8080/`

## 1. Target Audience
Before creating a campaign, it is essential to define a target audience. The target audience specifies the demographic and geographic criteria for the ad campaign. The target audience includes details such as the region and age range of the intended audience.
The requests needed to create a target audience are shown below.

## Endpoints for Target Audience

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
### `DELETE` Delete Existing Target Audience

**Endpoint:** `/targetaudience/{id}`

**Description:** Deletes the specified target audience by **ID**.

**Path Parameters:**
- `id` (Long): The unique identifier of the target audience.

**Responses:**

- **204 No Content:** Successfully closed
- **404 Not Found:** Issue not found

## 2. Campaign
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

The ID of each goal/campaign can be checked anytime with the requests specified here.

## Endpoints for Campaign

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
