## 1 Entering the URL and browser parsing

When you type https://www.example.com and press Enter:

#### 1 The browser parses the URL:

- Protocol: https → use TLS/SSL
- Domain: www.example.com
- Path: /

#### 2 The browser checks cache and history:

- Is there a local cached copy of the page?
- Are cookies available?
- Does it need to make a full request to the server?

## 2 DNS lookup (domain → IP)

#### 1 The browser checks its local DNS cache.
#### 2 If the IP is not found → the OS is queried, which may contact:
- Local DNS cache of the OS
- ISP DNS servers

#### 3 The DNS server returns the IP address of the server, e.g., www.example.com → 93.184.216.34.

## 3 Establishing a connection
### For HTTPS:

#### 1 Browser opens a TCP connection to port 443 (HTTPS) or 80 (HTTP).

#### 2 If HTTPS → TLS/SSL handshake occurs:
- Exchange certificates
- Authenticate server
- Create an encrypted channel
#### Now the browser can safely send requests and receive data.

## 4 Sending the HTTP request

#### Browser sends an HTTP request, for example:
```
GET / HTTP/1.1
Host: www.example.com
User-Agent: ...
Accept: ...
Cookies: ...
```

- It includes information about the browser, accepted formats, and cookies.
- The request goes over TCP to the server.

## 5 Server processes the request

#### 1 Web server (Nginx, Apache) routes the request.
#### 2 Backend application (Java, Node.js, Python, etc.) generates the response.
#### 3 Server sends HTTP response back:
```
HTTP/1.1 200 OK
Content-Type: text/html
Content-Length: 1256

<html>...</html>
```
## 6 Browser receives response and renders

### Browser processes the page:

#### 1 Parses HTML → builds DOM tree (Document Object Model)
#### 2 Parses CSS → builds CSSOM
#### 3 Combines DOM + CSSOM → Render Tree
#### 4 Computes layout → positions and sizes elements
#### 5 Painting → draws pixels on the screen
#### 6 Executes JS → modifies DOM, fetches data asynchronously

## 7 Additional details

- Caching: Browser may use cached files to avoid re-downloading resources
- Asynchronous loading: JS/CSS may load resources in parallel
- Cookies & sessions: Browser sends cookies; server may update session state
- Security: HTTPS encrypts data; CSP prevents attacks; CORS controls cross-origin requests

# Summary

### 1. Enter URL → browser parses
### 2. DNS lookup → get server IP
### 3. TCP/TLS connection → handshake
### 4. Send HTTP request
### 5. Server processes → generates response
### 6. Browser parses HTML/CSS → builds DOM/CSSOM → renders page
### 7. Page displayed to user