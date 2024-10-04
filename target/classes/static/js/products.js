document.addEventListener("DOMContentLoaded", function() {
    fetch('http://localhost:8081/api/products')
        .then(response => response.json())
        .then(data => {
            const productList = document.getElementById('productList');
            productList.innerHTML = '';
            data.forEach(product => {
                const row = document.createElement('tr');
                row.innerHTML = `
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.description}</td>
                    <td>${product.price}</td>
                    <td>${product.available ? 'Sim' : 'Não'}</td>
                `;
                productList.appendChild(row);
            });
        })
        .catch(error => console.error('Erro ao carregar produtos:', error));
});
