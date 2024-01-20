import { useState, useEffect } from "react";
import { retrieveAllTodosForUserName } from "./api/TodoApi";

function ListTodosComponent() {

    // const today = new Date()
    // const targetDate = new Date(today.getFullYear() + 12, today.getMonth(), today.getDay())

    const [todos, setTodos] = useState([])
    // const todos = [
    //     // {id:1, description: 'Learn AWS', done: false, targetDate: targetDate},
    //     // {id:2, description: 'Learn AWS', done: false, targetDate: targetDate},
    //     // {id:3, description: 'Learn AWS', done: false, targetDate: targetDate},
    //     // {id:4, description: 'Learn AWS', done: false, targetDate: targetDate},

    // ]

    useEffect(
        () => refreshTodos(), []
    )

    function refreshTodos() {
        retrieveAllTodosForUserName('admin')
        .then(response => {
            setTodos(response.data)
        })
        .catch(error => console.log(error))
    }

    return(
        <div className="container">
            <h1>Things to Do</h1>
            <div>
                <table className="table">
                    <thead>
                    <tr>
                        <td>id</td>
                        <td>description</td>
                        <td>done</td>
                        <td>targetDate</td>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        todos.map(
                            todo => (
                                <tr key={todo.id}>
                                    <td>{todo.id}</td>
                                    <td>{todo.description}</td>
                                    <td>{todo.completed.toString()}</td>
                                    {/* <td>{todo.targetDate.toDateString()}</td> */}
                                    <td>{todo.targetDate.toString()}</td>
                                </tr>
                            )
                        )
                    }
                    </tbody>
                </table>
            </div>
        </div>
    );
}

export default ListTodosComponent;