import { NumberValueAccessor } from "@angular/forms";

export interface User{
    id:number;
    first_name:string;
    last_name: string;
    user_name: string;
    password: string;
    email: string;
    dob:string;
    accno: number;
    blocked : Boolean;
    address:string;
    transfer_access:Boolean;
    samount:number;
    pamount:Number;
    validated:boolean;
}
