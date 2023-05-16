import React from 'react';
import { comments } from './commentData';

// receive props. The component should return two elements, 
//an <img> element whose src attribute will receive the profileImg property from props,
//and a <h1> element, displaying username from props.
function Header(props) {
    return (
        <div>
            <img src={props.profileImg} />
            <h1>{props.username}</h1>
        </div>
    );
}

export default Header;