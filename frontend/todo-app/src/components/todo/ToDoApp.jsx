
import { useState } from 'react';
import { BrowserRouter, Routes, Route, useNavigate, useParams } from 'react-router-dom';
import './ToDoApp.css';

export default function ToDoApp() {
    return(
        <div className="ToDoApp">
            <BrowserRouter>
                <Routes>
                    <Route path='/' element={<LoginComponent />} />
                    <Route path='/login' element={<LoginComponent />} />
                    <Route path='/welcome/:username' element={<WelcomeComponent />} />
                    <Route path='/todos' element={<ListTodosComponent/>} />
                    <Route path='*' element={<ErrorComponent />} />
                </Routes>
            </BrowserRouter>
        </div>
    );
}

function LoginComponent() {

    const[username, setUsername] = useState('admin')
    const[password, setPassword] = useState('')
    const[showSuccessMessage, setSuccessMessage] = useState(false)
    const[showErrorMessage, setErrorMessage] = useState(false)

    const navigate = useNavigate()



    function handleUserNameChange(event) {
        setUsername(event.target.value);
    }

    function handlePasswordChange(event) {
        setPassword(event.target.value);
    }

    function handleSubmit() {
        if(username === 'admin' && password === 'dummy'){
            setSuccessMessage(true)
            setErrorMessage(false)
            navigate(`/welcome/${username}`)
        }else {
            setSuccessMessage(false)
            setErrorMessage(true)
        }
    }

    function SuccessMessageComponent() {
        if(showSuccessMessage) {
            return <div className="successMessage">Authenticated Successfully</div>
        }

        return null
    }

    function ErrorMessageComponent() {
        if(showErrorMessage) {
            return <div className="errorMessage">Authentication Failed. Please check your credentials</div>
        }

        return null
    }


    return(
        <div className="Login">
            {showSuccessMessage && <div className="successMessage">Authenticated Successfully</div>}
            {showErrorMessage && <div className="errorMessage">Authentication Failed. Please check your credentials</div>}
            <div className="LoginForm">
                <div>
                    <label>User Name</label>
                    <input type="text" name="user_name" value={username} onChange={handleUserNameChange}/>
                </div>
                <div>
                    <label>Password</label>
                    <input type="password" name="password" value={password} onChange={handlePasswordChange}/>
                </div>
                <div>
                    <button type="button" name="login" onClick={handleSubmit}>Login</button>
                </div>
            </div>
        </div>
    );
}

function WelcomeComponent() {

    const {username} = useParams()

    console.log(username)

    return(
        <div className="Welcome">
            Welcome, {username}
        </div>
    );
}

function ErrorComponent() {
    return(
        <div className="Error">
            <h1>Sorry, Page doesn't Exist.</h1>
        </div>
    );
}


function ListTodosComponent() {

    const todos = [
        {id:1, description: 'Learn AWS'},
        {id:2, description: 'Learn AWS'},
        {id:3, description: 'Learn AWS'},
        {id:4, description: 'Learn AWS'},

    ]


    return(
        <div className="ListTodos">
            <h1>Things to Do</h1>
            <div>
                <table>
                    <thead>
                        <tr>
                            <td>id</td>
                            <td>description</td>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            todos.map(
                                todo => (
                                    <tr key={todo.id}>
                                        <td>{todo.id}</td>
                                        <td>{todo.description}</td>
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