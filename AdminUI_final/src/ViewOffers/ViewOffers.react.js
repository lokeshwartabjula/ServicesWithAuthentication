import React from 'react';
import { connect } from 'react-redux';
import './ViewOffers.css';
import { getOfferByThunk, deleteById, deleteOfferById } from '../Reducer';


class ViewOffers extends React.Component {
 
    componentWillMount(){
        this.props.get()
    }

    render() {if(!this.props.isLoaded){
        return(
            <div>  
                <h2>Loading..</h2>
              
               
            </div>
        )
    } else{


    return (
        <div className='viewoffers_wrapper'>
            <p>Show offers</p>

            {
                this.props.list.map((eachOffer,index) => {
                    return <div key={index}>
                            Offer Name:<p>{eachOffer.offerName}</p>
                            <button onClick={()=>this.props.delete(eachOffer.offerCode)}>Delete</button>
                        </div>
                })
            }



        </div>
    );

}
}

}
const mapStateToProps = (state) => {
    return {
        list: state.payload,
        isLoaded: state.isOfferLoaded
    }
}
const mapDispatchToProps = (dispatch) => {
    return {
        get: () => {
            dispatch(getOfferByThunk())
        },

        delete: (id) => {
            console.log("delelte  props "+id)
            deleteOfferById(id)
        }
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(ViewOffers);