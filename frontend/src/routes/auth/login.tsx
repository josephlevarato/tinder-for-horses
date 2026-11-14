import { createFileRoute } from '@tanstack/react-router'
import { useState } from 'react'

export const Route = createFileRoute('/auth/login')({
  component: RouteComponent,
})

function RouteComponent() {

  const [horse, setHorse] = useState('')

  async function login() {
    await fetch('/api/auth/login', {
      method: 'POST',
      credentials: 'include',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ email: 'jhorse@gmail.com', password: 'password' }),
    })
  }

  async function getInfos() {
    const data = await fetch('/api/horses/me', {
      credentials: 'include',
      headers: { 'Content-Type': 'application/json' },
    })
    console.log(data)
  }

  return <>
    <div>
      <button onClick={login}>
        Update value
      </button>
    </div>

    <div>
      <button onClick={getInfos}>
        Get horse info
      </button>
    </div>

    <div>{horse}</div>
  </>
}
