import { Category } from "./category.model";

export interface SubCategory extends Category {
  subCategoryId: number;
  subCategoryName: string;
    category: Category;
  }