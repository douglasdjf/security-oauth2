## Spring Security Basic Auth e OAuth2

### Basic Auth ativar profile
```
srping.profiles.active=basic-security
```
#### Credencial: 

Username : admin@admin.com

Password : admin


### OAuth2 ativar profile 
```
srping.profiles.active=oauth-security
```

Body Request formato x-www-form-urlencoded  exemplo :

| KEY        | VALUE           |
|------------|-----------------|
| client     | angular         |
| username   | admin@admin.com |
| password   | admin           |
| grant_type | password        |