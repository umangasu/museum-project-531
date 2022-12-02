// import React, { useState, useEffect } from "react";
import { useParams } from 'react-router-dom';

import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import { CardActionArea } from '@mui/material';
import axios from "axios";
import { Link } from "react-router-dom";

const { Meta } = Card;

const baseURL = 'http://localhost:8080/smartMuseum/artwork/';

export default function ArtworkDetail(props) {
    const { artworkId } = useParams()
    const [artworkData, setArtworkData] = React.useState(null);

    React.useEffect(() => {
        axios.get(baseURL.concat(artworkId)).then((response) => {
            console.log('before setting artwork data to json', response.data);
            setArtworkData(response.data);
            console.log('after setting artwork data to json', artworkData);
        })
    }, artworkData)


    return (
        <div style={{width: '100%'}}>
            <div
                style={{display: 'flex', width: '100%', alignItems: 'center', justifyContent: 'center'}}
            >
                <div style={{
                    maxWidth: 500, 
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
                <Card sx={{ maxWidth: 500, marginTop: '20px', width: 500}}>
                    <CardContent>
                        <Typography gutterBottom variant="h6" component="div">
                        {artworkData && artworkData.title}
                        </Typography>
                        <Typography variant="body2" color="text.secondary">
                        {artworkData && artworkData.description}
                        </Typography>
                    </CardContent>
                </Card>
            </div>
            <div style={{display: 'flex', width: '100%', alignItems: 'center', justifyContent: 'center'}}>
                <Card sx={{ maxWidth: 500, marginTop: '20px', width: 500}}>
                    <CardContent>
                        <Typography gutterBottom variant="h6" component="div">
                        Dimensions
                        </Typography>
                        <div style={{display: 'flex'}}>
                            <Typography variant="body2" color="text.primary">
                            Height &nbsp;
                            </Typography>
                            <Typography variant="body2" color="text.secondary">
                            {artworkData && artworkData.height} &nbsp; | &nbsp;
                            </Typography>
                            <Typography variant="body2" color="text.primary">
                            Width &nbsp;
                            </Typography>
                            <Typography variant="body2" color="text.secondary">
                            {artworkData && artworkData.width.split("^^")[0]} &nbsp; | &nbsp;
                            </Typography>
                            <Typography variant="body2" color="text.primary">
                            Depth &nbsp;
                            </Typography>
                            <Typography variant="body2" color="text.secondary">
                            {artworkData && artworkData.depth}
                            </Typography>
                        </div>
                    </CardContent>
                </Card>
            </div>
            <div style={{display: 'flex', width: '100%', alignItems: 'center', justifyContent: 'center'}}>
                <Card sx={{ maxWidth: 500, marginTop: '20px', width: 500}}>
                    <CardContent>
                        <Typography gutterBottom variant="h6" component="div">
                        Artist
                        </Typography>
                        <div style={{display: 'flex'}}>
                            
                            <Link 
                                to={`/artists/${artworkData && artworkData['artistID'].split("^^")[0]}`}
                                style={{
                                    textDecoration: 'None',
                                }}
                            >
                                <Typography variant="body2" color="text.secondary">
                                {artworkData && artworkData.artistName}
                                </Typography>
                            </Link>
                        </div>
                    </CardContent>
                </Card>
            </div>
        </div>
    )
}