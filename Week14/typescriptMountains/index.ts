// tallest mountain
interface Mountain{
    name: string;
    height: number;
}

const mountains: Mountain[] = [
    {name: "Kilimanjaro", height: 19341},
    {name: "Everest", height: 29029},
    {name: "Denali", height: 20310}
];

function findNameOfTallestMountain(mountains: Mountain[]): string {
    let tallestName = mountains[0].name;
    let tallestHeight = mountains[0].height;

    for (let i = 1; i < mountains.length; i++) {
        if (mountains[i].height > tallestHeight){
            tallestName= mountains[i].name;
            tallestHeight= mountains[i].height;
        }
    }
    return tallestName;
}

console.log(findNameOfTallestMountain(mountains));

// products
interface Product{
    name: string;
    price: number;
}

const products:Product[] = [
    {name: "Soap", price: 2.99},
    {name: "Spoon", price: 5},
    {name: "Spaghetti", price: 3.99}
]

function calcAverageProductPrice(products: Product[]): number {
    let sum = 0;
    let count = 0;

    for (let product of products){
        sum += product.price
        count ++
    }
    return sum / count
}

// console.log(calcAverageProductPrice(products));


// Inventory
interface InventoryItem {
    product: Product;
    quantity: number;
}

const inventory:InventoryItem[] = [
    {product: {name: "motor", price: 10.00}, quantity: 10},
    {product: {name: "sensor", price: 12.50}, quantity: 4},
    {product: {name: "LED", price: 1.00}, quantity: 20}
]

function calcInventoryValue(inventory:InventoryItem[]): number {
    let total = 0;
    for (let item of inventory){
        total += item.product.price * item.quantity;
    }
    return total;
}

// console.log(calcInventoryValue(inventory));