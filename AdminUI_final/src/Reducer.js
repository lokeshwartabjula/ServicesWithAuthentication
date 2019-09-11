 import axios from 'axios';
import { applyMiddleware, createStore } from 'redux';
import thunk from 'redux-thunk';

const initialState={
    isLoaded:false,
    list:[{}]
}



export const getDriverAction=(list,status)=>{
    console.log("in get action" +status +" ** before GET_ALL_DRIVERS")
    return{
        type:'GET_ALL_DRIVERS',
        payload: list,
        isLoaded:status
    }

    
}

export const deleteDriverAction=(id)=>{
    return{
        type:'DELETE_DRIVER',
        id:id,
    }
}

export function getListByThunk(){

    console.log("get list by thunk")
    return function(dispatch){
        console.log(restStore.getState())
        return axios.get("http://localhost:8080/viewDrivers")
        .then(resp=>dispatch(getDriverAction(resp.data,true)));

    }
      
}

export function getOfferByThunk(){

    console.log("get offer by thunk")
    return function(dispatch){
        console.log(restStore.getState())
        return axios.get("http://localhost:8099/viewOffers").then(resp=>{
        
        dispatch(getOffersAction(resp.data,true))
            
    
    });

    }
}


export const getOffersAction=(list,status)=>{

    return{
        type:'GET_ALL_OFFERS',
        payload: list,
        isOfferLoaded:status
    }

    
}


export function deleteDriverByThunk(id){
   
console.log(id);
    return axios.delete("http://localhost:8080/deleteDriver/"+id)
    
}

export function deleteDriverById(id){

   
    deleteDriverByThunk(id);
}

export function deleteOfferByThunk(id){
   
    console.log(id);
        return axios.delete("http://localhost:8099/deleteOffer/"+id)
        
    }
    
    export function deleteOfferById(id){
    
       
        deleteOfferByThunk(id);
    }

// const responseFromServer=(response)=>{

//     return{
//         type:'SERVER_RESPONSE',
//         statusCode:response
//     }
// }

export const driverReducer=(state=initialState,action)=>{
    
    switch(action.type){
        case 'GET_ALL_DRIVERS':
            return Object.assign({},action);
        case 'DELETE_DRIVER':
            return Object.assign({},action);
            case 'GET_ALL_OFFERS':
            return Object.assign({},action);
        // case 'SERVER_RESPONSE':
        //     return Object.assign({},action);
        // case 'DATA_INPUT_CHANGE':
        //     return Object.assign({},action);
        default:
            return state
    }
}

let restStore= createStore(driverReducer,applyMiddleware(thunk));

export default restStore;