import {BrowserRouter, Routes, Route, Navigate} from 'react-router-dom';
import './ToDoApp.css';
import LoginComponent from "./LoginComponent";
import LogoutComponent from "./LogoutComponent";
import HeaderComponent from "./HeaderComponent";
import WelcomeComponent from "./WelcomeComponent";
import ListTodosComponent from "./ListTodosComponent";
import ErrorComponent from "./ErrorComponent";
import AuthProvider, { useAuth } from "./security/AuthContext";

export default function ToDoApp() {
    return(
        <div className="ToDoApp">
            <AuthProvider>
                <BrowserRouter>
                    <HeaderComponent/>
                    <Routes>
                        <Route path='/' element={<LoginComponent />} />
                        <Route path='/login' element={<LoginComponent />} />
                        <Route path='/logout' element={
                            <AuthenticatedRoute> 
                                <LogoutComponent />
                            </AuthenticatedRoute>
                        } />
                        <Route path='/welcome/:username' element={
                            
                                <WelcomeComponent />
                        
                        
                        } />
                        <Route path='/todos' element={
                                <ListTodosComponent/>         
                        } />
                        <Route path='*' element={<ErrorComponent />} />
                    </Routes>
                </BrowserRouter>
            </AuthProvider>
        </div>
    );
}

function AuthenticatedRoute({childern}) {
    const authContext = useAuth() 
    if(authContext.isAuthenticated) {
        console.log(authContext.isAuthenticated)
        return childern
    } 
    return <Navigate to="/"/>
}
