import { createFileRoute } from '@tanstack/react-router'
import { useSelector } from '@tanstack/react-store'

import test from '#/stores/auth'

export const Route = createFileRoute('/auth/login')({
  component: RouteComponent,
})



function RouteComponent() {
  const storeValue = useSelector(test)
  function updateValue() {
    test.setState(() => 'Hello bjr')
  }

  return <>
    <div>Hello "/auth/login"!</div>
    <div>
      <p>Current store value : {storeValue}</p>
    </div>
    <div>
      <button onClick={updateValue}>
        Update value
      </button>
    </div>
  </>
}
