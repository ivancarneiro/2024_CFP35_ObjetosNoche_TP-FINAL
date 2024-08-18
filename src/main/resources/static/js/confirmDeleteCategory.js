function confirmDeleteCategory(categoria) {
    // console.log(categoria);
    return confirm(`¿Estás seguro de que deseas eliminar la categoría\n id: ${categoria.id} | ${categoria.category} - ${categoria.type} ?`);
}