# Social Media Application - Resources and Methods

## Users REST API
- Retrieve all Users
  - **GET** `/users`
- Create a User
  - **POST** `/users`
- Retrieve one User
  - **GET** `/users/{id}` -> `/users/1`
- Delete a User
  - **DELETE** `/users/{id}`


## POSTs REST API
- Retrieve all posts of a User
  - **GET** `/users/{id}/posts`
- Create a post for a User
  - **POST** `/users/{id}/posts`
- Retrieve details of a post
  - **GET** `/users/{id}/posts/{post_id}`