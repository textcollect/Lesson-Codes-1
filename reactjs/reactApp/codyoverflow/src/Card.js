import React from 'react';
import Header from './Header';
import Body from './Body';

/*
Card will be the outer “shell” that contains our two smaller components: 
Card is the parent, and Header and Body are the child components.

Begin defining the Card component. Card should receive props.

Card should return an instance of the Header component, 
and an instance of the Body component.
*/

function Card(props) {
    return (
    <div>
        <Header profileImg={props.commentObject.profileImg} username={props.commentObject.username} />
        <Body comment={props.commentObject.comment} />
    </div>);
}

export default Card;