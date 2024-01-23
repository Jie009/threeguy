async function login() {
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    if (!username || !password) {
        document.getElementById('errorMessage').innerText = 'Please enter both username and password';
        return;
    }

    // 假设这里使用POST请求发送用户输入到后端
    const response = await fetch('/api/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ username, password }),
    });

    const result = await response.json();

    if (result.success) {
        // 登录成功的处理逻辑
        alert('Login successful!');
    } else {
        // 登录失败的处理逻辑
        document.getElementById('errorMessage').innerText = 'Invalid username or password';
    }
}

// async function getAllUsers() {
//     try {
//         const response = await fetch('/api/users');
//         const users = await response.json();
//
//         console.log('All Users:', users);
//     } catch (error) {
//         console.error('Error fetching users:', error);
//     }
// }

