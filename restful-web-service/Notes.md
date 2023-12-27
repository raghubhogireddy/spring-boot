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