import { Link } from '@tanstack/react-router'
import useHorseStore from '#/stores/auth'

export default function Header() {
    const currentHorse = useHorseStore((h) => h.horse)
    return (
        <header>
            <nav className="px-2">
                <Link to="/">
                    <h1 className="text-2xl font-bold">
                        Hoof'd
                    </h1>
                </Link>
                {currentHorse && (
                    <p>{currentHorse.firstName}</p>
                )}
            </nav>
        </header>
    )
}