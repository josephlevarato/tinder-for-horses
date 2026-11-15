import type { Horse } from '#/types/horse'
import { create } from 'zustand'
import { persist } from 'zustand/middleware'

interface States {
    horse: Horse | undefined
    authenticated: boolean
}

interface Actions {
    updateCurrentHorse: (horse: Horse) => void
    updateAuthenticatedStatus: (status: boolean) => void
}

const useHorseStore = create<States & Actions>()(
    persist(
        (set) => ({
            horse: undefined,
            authenticated: false,
            updateCurrentHorse: (horse: Horse) => set(() => ({ horse })),
            updateAuthenticatedStatus: (status: boolean) => set(() => ({ authenticated: status }))
        }),
        {
            name: 'hoofd-auth',
        }
    ),
)

export default useHorseStore