Json Structure
 http://localhost:6060/api/auth/register {
    "name": "John Doe",
    "email": "john.doe@example.com",
    "password": "password123",
    "role": "CUSTOMER"
} 
Response {
    "role": "CUSTOMER",
    "name": "John Doe",
    "id": 1,
    "email": "john.doe@example.com"
}
http://localhost:6060/api/auth/login {
    "email": "john.doe@example.com",
    "password": "password123"
}
Response {
    "message": "Login successful",
    "user": {
        "role": "CUSTOMER",
        "email": "john.doe@example.com",
        "name": "John Doe",
        "id": 1
    }
}
