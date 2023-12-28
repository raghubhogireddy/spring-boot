# What's Happening in the background
## How are our requests handled ?
- **DispatcherServlet** - Front Controller pattern
  - Mapping servlets: dispatcherServlet urls=[ / ]
  - **Auto Configuration** (DispatcherServletAutoConfiguration)
## How does POJO/Java bean object converted to JSON ?
- `@ResponseBody` + JacksonHttpMessageConverters 
## Who is configuring error mapping ?
- Auto Configuration (ErrorMvcAutoConfiguration)

## Request Methods for REST API
- **GET** - Retrieve details of a resource
- **POST** - Create a new resource
- **PUT** - Update an existing resource
- **PATCH** - Update part of a resource
- **DELETE** - Delete a resource

## Response Status for REST API
- Return the correct response status
  - Resource is not found => 404
  - Server Exception => 500
  - Bad Request (Validation Error) => 400
  - Success => 200
  - Created => 201
  - No Content => 204
  - Unauthorized (when authorization fails) => 401

## Rest API Documentation
- REST API consumers need to understand our APIs
  - Resources
  - Actions
  - Request/Response Structure (Constraints/Validations)
- Challenges
  - Accuracy : How do your ensure that your documentation is upto date and correct
  - Consistency : you might have 100s od APIs in an enterprise. How do you ensure consistency
- Options
  - Manually maintain Documentation
    - Additional effort to keep it in sync with code
  - Generate from code

## Content Negotiation
- Same Resource - Same URI
- However Different representations are possible
  - Ex : Different Content Type : XML or JSON 
  - EX : Different Language : English or Dutch
- How can a consumer tell the REST API provider what they want
  - **Content Negotiation**
  - Ex : Accept Header (MIME types) - application/xml, application/json..
  - Ex : Accept-Language Header - en, nl, fr..

## Versioning REST API
- versioning for REST API can be done in below options
  - URL
  - Request Parameter
  - Header
  - Media Type
- Factors to consider
  - URI Pollution
  - Misuse of HTTP Headers
  - Caching
  - API Documentation

## HATEOAS
- Hypermedia as the Engine of Application State
  - Websites allow you to 
    - See Data AND perform Actions (using links)
  - enhances REST API to tell consumers how to perform subsequent actions
- Implementation Options
  - Custom Format and Implementation - Difficult to maintain
  - User Standard Implementation
    - HAL (JSON Hypertext Application Language) : Simple format that gives a consistent and easy way to hyperlink between resources in your API
    - **Spring HATEOAS**: Generates HAL responsesf with hyperlinks to resources