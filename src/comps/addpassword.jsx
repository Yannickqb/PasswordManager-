import * as React from 'react';
import Button from '@mui/material/Button';
import Stack from '@mui/material/Stack';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import WebseiteIcon from '../img/internet.png';
import PasswordIcon from '../img/smart-lock.png';
import UserIcon from '../img/user.png';
import { useState } from 'react';


export function InputWithIcon() {


    const [link, setLink] = useState()
    const [usernameSite, setUsernameSite] = useState()
    const [passwordSite, setPasswordSite] = useState()

    const safePassword = () => {
        fetch("localhost:8080/addPassword", {
            method: "POST",
            headers: { "Contet-type": "applycations/Json" },
            body: JSON.stringify({
                "usernameSite": usernameSite,
                "link": link,
                "passwordSite": passwordSite,

            })
        })
    }

    return (
        <>
        
        <Box sx={{ width: '300px', backgroundColor: '#bebebe', borderStyle: 'solid' }}>
            <Box sx={{ display: 'flex', alignItems: 'flex-end' }}>
                <img src={WebseiteIcon} height={30} />
                <TextField id="webseite" label="Webseite" variant="standard" onChange={(e) => setLink(e.target.value)} />
            </Box>
            <Box sx={{ display: 'flex', alignItems: 'flex-end' }}>
                <img src={UserIcon} height={30} />
                <TextField id="uername" label="Username" variant="standard" onChange={(e) => setUsernameSite(e.target.value)} />
            </Box>
            <Box sx={{ display: 'flex', alignItems: 'flex-end' }}>
                <img src={PasswordIcon} height={30} />
                <TextField id="password" label="Password" variant="standard" onChange={(e) => setPasswordSite(e.target.value)} />
            </Box>
            <Stack direction="row" spacing={2}>
                <Button onClick={safePassword()}>Safe</Button>
            </Stack>
        </Box>
        </>
    );
    }  
