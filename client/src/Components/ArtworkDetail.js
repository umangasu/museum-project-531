// import React, { useState, useEffect } from "react";
import { useParams } from 'react-router-dom';

import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import { CardActionArea } from '@mui/material';
import axios from "axios";

const { Meta } = Card;

const baseURL = 'http://localhost:8080/smartMuseum/artwork/1'

export default function ArtworkDetail(props) {
    // const { artworkId } = useParams()
    console.log('bruh outside');
    const artworkId = 9;
    const [artworkData, setArtworkData] = React.useState(null);

    React.useEffect(() => {
        axios.get(baseURL).then((response) => {
            console.log('before setting artwork data to json', response.data);
            setArtworkData(response.data);
            console.log('after setting artwork data to json', artworkData);
        })
    }, [artworkData])


    return (
        <div style={{width: '100%'}}>
            <div
                style={{display: 'flex', width: '100%', alignItems: 'center', justifyContent: 'center'}}
            >
                <div style={{
                    maxWidth: 500, 
                    // maxHeight: 500, 
                    marginTop: '20px'
                }}>
                    <img 
                        src={artworkData && artworkData['imageUrl']}
                        style={{
                            maxWidth: '100%',
                            maxHeight: '100%',
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
                        {artworkData && artworkData.title}
                        </Typography>
                        <Typography variant="body2" color="text.secondary">
                        {artworkData && artworkData.description}
                        </Typography>
                    </CardContent>
                    {/* </CardActionArea> */}
                </Card>
            </div>
            <div style={{display: 'flex', width: '100%', alignItems: 'center', justifyContent: 'center'}}>
                <Card sx={{ maxWidth: 500, marginTop: '20px'}}>
                    {/* <CardActionArea> */}
                    <CardContent>
                        <Typography gutterBottom variant="h5" component="div">
                        {artworkData && artworkData.title}
                        </Typography>
                        <Typography variant="body2" color="text.secondary">
                        {artworkData && artworkData.description}
                        </Typography>
                    </CardContent>
                    {/* </CardActionArea> */}
                </Card>
            </div>
        </div>
    )
}