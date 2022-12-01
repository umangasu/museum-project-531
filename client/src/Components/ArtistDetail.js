// import React, { useState, useEffect } from "react";
import { useParams } from 'react-router-dom';

import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import { CardActionArea } from '@mui/material';
import Artwork from './Artwork';

const { Meta } = Card;

export default function ArtistDetail() {
    return (
        <>
        <div style={{width: '100%'}}>
            <div 
                style={{position: 'relative'}}
            >
                        
                <div>
                    <img 
                        src='https://i.pinimg.com/736x/48/8e/ca/488ecae926cecf65c0439c03a0906376.jpg'
                        style={{
                            filter: 'blur(3px)',
                            height: '200px',
                            width: '100%',
                            position: 'relative',
                            // borderBottom: '5px solid black'
                            // marginTop: '40px',
                            // zIndex: 3
                        }}
                    >

                    </img>
                </div>
                {/* <div style={{height: '5px', backgroundColor: 'black', width: '100%'}}>
                    
                </div> */}
                <div style={{display: 'flex', width: '100%', alignItems: 'center', justifyContent: 'center'}}>
                    <img 
                        src='https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTKAGia3COeBXxUXJ1K8G82_IlcYQqjkzYKZB53vl_v_7rroFHjb4A9diTKCf-cs9JTNro&usqp=CAU'
                        style={{
                            borderRadius: '50%',
                            // borderColor: 'black',
                            // borderWidth: '5px',
                            // borderStyle: 'solid',
                            width: '90px',
                            height: '90px',
                            // marginLeft: '46%',
                            marginTop: '-10px',
                            position: 'absolute',
                            // zIndex: 1
                        }}
                    >

                    </img>
                </div>
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
        <Artwork/>
        </>

    )
}