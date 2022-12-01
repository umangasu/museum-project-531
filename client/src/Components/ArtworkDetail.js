// import React, { useState, useEffect } from "react";
import { useParams } from 'react-router-dom';

import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import { CardActionArea } from '@mui/material';

const { Meta } = Card;

export default function ArtworkDetail() {
    return (
        <div style={{width: '100%'}}>
            <div style={{display: 'flex', width: '100%', alignItems: 'center', justifyContent: 'center'}}>
                <Card sx={{ maxWidth: 500, marginTop: '20px'}}>
                    <div>
                        <img 
                            src='https://sep.yimg.com/ty/cdn/madisonartshop/most-famous-paintings-2.jpg?t=1660737943&'
                            // style={{
                            //     filter: 'blur(3px)',
                            //     height: '200px',
                            //     width: '100%',
                            //     position: 'relative',
                            //     // borderBottom: '5px solid black'
                            //     // marginTop: '40px',
                            //     // zIndex: 3
                            // }}
                        >

                        </img>
                    </div>
                </Card>
            </div>
            <div style={{display: 'flex', width: '100%', alignItems: 'center', justifyContent: 'center'}}>
                <Card sx={{ maxWidth: 500, marginTop: '20px'}}>
                    {/* <CardActionArea> */}
                    <CardContent>
                        <Typography gutterBottom variant="h5" component="div">
                        Van Gogh
                        </Typography>
                        <Typography variant="body2" color="text.secondary">
                        Lizards are a widespread group of squamate reptiles, with over 6,000
                        species, ranging across all continents except Antarctica
                        </Typography>
                    </CardContent>
                    {/* </CardActionArea> */}
                </Card>
            </div>
        </div>
    )
}