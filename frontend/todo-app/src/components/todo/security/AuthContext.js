import {useState, createContext, useContext} from "react";


export const AuthContext = createContext()
export const useAuth = () => useContext(AuthContext)

function AuthProvider({children}) {
    
    const [number, setNumber] = useState(10);
    
    setInterval(() => setNumber(number + 1), 10000)
    
    
    return (
        <AuthContext.Provider value={{number}}>
            {children}
        </AuthContext.Provider>
    );
}

export default AuthProvider;