import { SellerModel } from "./sellerModel";
import { SubCategory } from "./subcategory.model";


export interface Product {
  productName: string,
  productImageURL: string,
  description: string,
  price: number,
  stockQuantity: number,
  brand: string,
  createdAt: Date, 
  modifiedAt: Date,

   
    seller: SellerModel; 
   
    subCategory: SubCategory;
  }