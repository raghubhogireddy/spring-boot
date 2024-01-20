import axios from "axios";

// export function retrieveHelloWorld() {
//     //axios
//     return axios.get("http://localhost:8080/hello-world")
// }


const apiClient = axios.create(
    {
        baseURL: 'http://localhost:8080'
    }
)

export const retrieveHelloWorld = 
            () => apiClient.get("/hello-world")


export const retrieveHelloWorldPathVariable = 
            (username) => apiClient.get(`/hello-world/path-variable/${username}`)