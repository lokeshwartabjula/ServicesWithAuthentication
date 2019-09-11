import React from 'react';

import './CustomComp.css';

class CustomComp extends React.Component {
    constructor(props) {
        super(props);
    //THE BELOW COMMENTED FUNCTION IS A SAMPLE FUNCTION THAT HAS THE TEMPLATE THAT SHOULD BE FOLLOWED IN EVERY POST FUNCTION IN YOUR COMPONENT
        // handleVoteSubmit(event, pollIndex) {
        //     event.preventDefault();
        //     if(!this.props.isAuthenticated) {            //THIS IS TO CHECK IF THE USER IS AUTHENTICATED... IF THIS PROPS IS NOT PASSED BY THE PARENT COMPONENT, THE USER IS FOUND TO BE NOT AUTHENTICATED.. SO EVEN IF THE API IS EXPOSED ITS NOT GOING TO BE A PROBELM
        //         this.props.history.push("/login");
        //         notification.info({
        //             message: 'Polling App',
        //             description: "Please login to vote.",          
        //         });
        //         return;
        //     }
    
        //     const poll = this.state.polls[pollIndex];
        //     const selectedChoice = this.state.currentVotes[pollIndex];
    
        //     const voteData = {
        //         pollId: poll.id,
        //         choiceId: selectedChoice
        //     };
    
        //     castVote(voteData)
        //     .then(response => {
        //         const polls = this.state.polls.slice();
        //         polls[pollIndex] = response;
        //         this.setState({
        //             polls: polls
        //         });        
        //     }).catch(error => {
        //         if(error.status === 401) {
        //             this.props.handleLogout('/login', 'error', 'You have been logged out. Please login to vote');    
        //         } else {
        //             notification.error({
        //                 message: 'Polling App',
        //                 description: error.message || 'Sorry! Something went wrong. Please try again!'
        //             });                
        //         }
        //     });
        // }
    }

    render() {
        return (

            <div className='customcomp_wrapper'>
                 <h1>CUSTOM COMPONENT</h1>
                 <a href="www.google.com">driver app link</a>
                 <a href="www.facebook.com">admin app link</a>
                 <a href="www.amazon.com">passenger app link</a>
            </div>
        );
    }
}

export default CustomComp;