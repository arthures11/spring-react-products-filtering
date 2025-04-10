import logo from './logo.svg';
import './App.css';
import React, { useState, useEffect } from 'react';

var a=0;
const ProductList = () => {
    const [products, setProducts] = useState([]);
    const [category, setCategory] = useState('');
    const [producer, setProducer] = useState('');
    const [sortOption, setSortOption] = useState('');
    const [searchQuery, setSearchQuery] = useState('');
    const [promocja, setPromocja] = useState('');

    useEffect(() => {
        const fetchProducts = async () => {
            const url = `/products?category=${category}&producer=${producer}&sort=${sortOption}&name=${searchQuery}&promocja=${promocja}`;
            if(a>0) {
                const response = await fetch(url);
                const data = await response.json();
                setProducts(data);
            }
            a=1;
        };

        fetchProducts();

    }, [category, producer, sortOption, searchQuery, promocja]);


    return (
        <div className="App">
            <header className="App-header">
                <img src={logo} className="App-logo" alt="logo"/>
                <div>
                    <select value={category} onChange={(e) => setCategory(e.target.value)}>
                        <option value="">wszystkie kategorie</option>
                        <option value="Laptop">Laptop</option>
                        <option value="Klawiatura">Klawiatura</option>
                        <option value="Komputer">Komputer</option>
                        <option value="Mysz">Mysz</option>
                        <option value="Klawiatura">Klawiatura</option>
                    </select>

                    <select value={producer} onChange={(e) => setProducer(e.target.value)}>
                        <option value="">wszyscy producenci</option>
                        <option value="Intel">Intel</option>
                        <option value="HP">HP</option>
                        <option value="ASUS">ASUS</option>
                        <option value="Acer">Acer</option>
                    </select>

                    <select value={sortOption} onChange={(e) => setSortOption(e.target.value)}>
                        <option value="">brak sortowania</option>
                        <option value="price-lowest">cenowo(od najniższej do najwyższej)</option>
                        <option value="price-highest">cenowo(od najwyższej do najniższej)</option>
                    </select>

                    {/*<select value={promocja} onChange={(e) => setPromocja(e.target.value)}>*/}
                    {/*    <input type="checkbox" >promocja</input>*/}
                    {/*</select>*/}

                    <select value={sortOption} onChange={(e) => setPromocja(e.target.value)}>
                        <option value="">brak sortowania</option>
                        <option value="promocje">promocje</option>
                        <option value="bez-promocji">bez promocji</option>
                    </select>

                    <input type="text" value={searchQuery} onChange={(e) => setSearchQuery(e.target.value)}
                           placeholder="szukaj po nazwie"/>

                    <div className="product-grid">
                        {products.map((product, index) => (
                            <div key={product.id} className="product-item">
                                <h3>{product.name}</h3>
                                <p>Category: {product.category}</p>
                                <p>Producer: {product.producer}</p>
                                <p>Description: {product.description}</p>
                                <p>Price: ${product.price}</p>
                                <img src={product.image} alt={product.name} />
                            </div>
                        ))}
                    </div>
                </div>
            </header>
        </div>
    );
}


export default ProductList;