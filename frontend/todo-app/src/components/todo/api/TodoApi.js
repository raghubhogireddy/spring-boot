import axios from "axios";

export const apiClient = axios.create(
    {
        baseURL: 'http://localhost:8080/users'
    }
)

export const retrieveAllTodosForUserName = 
            (username) => apiClient.get(`/${username}/todos`)